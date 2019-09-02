package com.chaochaogu.annotation;

import java.lang.annotation.*;

/**
 * Repeatable annotation type
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTest2Container.class)
public @interface ExceptionTest2 {
    Class<? extends Exception> value();
}
