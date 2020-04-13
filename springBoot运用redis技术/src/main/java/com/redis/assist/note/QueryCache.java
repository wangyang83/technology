package com.redis.assist.note;

import com.redis.assist.enumerate.CacheNameSpace;

import java.lang.annotation.*;

/**
 * @author 王阳
 * @date 2020/4/10 9:19
 * 用来标识查询数据库的方法
 * A
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface QueryCache {
    CacheNameSpace nameSpace();
}
