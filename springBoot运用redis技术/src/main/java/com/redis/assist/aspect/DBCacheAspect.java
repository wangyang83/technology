package com.redis.assist.aspect;

import com.redis.assist.enumerate.CacheNameSpace;
import com.redis.assist.note.QueryCache;
import com.redis.assist.note.QueryCacheKey;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.SynthesizingMethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author 王阳
 * @date 2020/4/10 9:56
 * A
 */
@Aspect
@Service
public class DBCacheAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBCacheAspect.class);
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 定义拦截规则：拦截所有@QueryCache注解的方法。
     */
    @Pointcut("@annotation(com.redis.assist.note.QueryCache)")
    public void queryCachePointcut(){}
    /**
     * 拦截器具体实现
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("queryCachePointcut()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        LOGGER.info("AOP 缓存切面处理 >>>> start ");
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        CacheNameSpace cacheType = method.getAnnotation(QueryCache.class).nameSpace();
        String key = null;
        int i = 0;
        // 循环所有的参数
        for (Object value : pjp.getArgs()) {
            MethodParameter methodParam = new SynthesizingMethodParameter(method, i);
            Annotation[] paramAnns = methodParam.getParameterAnnotations();
            // 循环参数上所有的注解
            for (Annotation paramAnn : paramAnns) {
                if ( paramAnn instanceof QueryCacheKey) { //
                    QueryCacheKey requestParam = (QueryCacheKey) paramAnn;
                    key = cacheType.name() + "_" + value;   // 取到QueryCacheKey的标识参数的值
                }
            }
            i++;
        }
        // 获取不到key值，抛异常
        if (StringUtils.isBlank(key)){
            throw new Exception("缓存key值不存在");
        }
        LOGGER.info("获取到缓存key值 >>>> " + key);
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            // 缓存中获取到数据，直接返回。
            Object object = operations.get(key);
            LOGGER.info("从缓存中获取到数据 >>>> " + object.toString());
            LOGGER.info("AOP 缓存切面处理 >>>> end 耗时：" + (System.currentTimeMillis() - beginTime));
            return object;
        }
        // 缓存中没有数据，调用原始方法查询数据库
        Object object = pjp.proceed();
        operations.set(key, object, 30, TimeUnit.MINUTES); // 设置超时时间30分钟
        LOGGER.info("DB取到数据并存入缓存 >>>> " + object.toString());
        LOGGER.info("AOP 缓存切面处理 >>>> end 耗时：" + (System.currentTimeMillis() - beginTime));
        return object;
    }

}
