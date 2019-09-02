package com.chaochaogu.annotation;

import java.lang.annotation.*;

/**
 * Annotation Type with an array parameter
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest1 {
    Class<? extends Throwable>[] value();
}
