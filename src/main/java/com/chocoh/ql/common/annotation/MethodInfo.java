package com.chocoh.ql.common.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author chocoh
 * @createTime 2024-03-20 09:16
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    boolean timingInfo() default true;

    boolean argsInfo() default true;

    boolean returnInfo() default true;

    String message() default "";
}
