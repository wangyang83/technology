package com.redis.assist.note;

import java.lang.annotation.*;

/**
 * @author 王阳
 * @date 2020/4/10 9:22
 * A
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface QueryCacheKey {
}
