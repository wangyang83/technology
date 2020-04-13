package com.redis.assist.aspect;

import com.redis.assist.domain.BaseDomain;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author 王阳
 * @date 2020/4/9 14:59
 */
@Aspect
@Component
public class BaseAspect {
    final static Logger logger = LoggerFactory.getLogger(BaseAspect.class);

    @Before("execution(public * com.redis..*.*Mapper.insert*(..)) &&  args(baseDomain,..)")
    public void appendInsertInfo(BaseDomain baseDomain) throws Exception{
        baseDomain.setCreateDate(new Date());
        baseDomain.setCreateUser("admin");
    }

    @Before("execution(public * com.redis..*.*Mapper.update*(..)) &&  args(baseDomain,..)")
    public void appendUpdateInfo(BaseDomain baseDomain) throws Exception{
        baseDomain.setUpdateDate(new Date());
        baseDomain.setUpdateUser("admin");
    }



}
