package com.chaochaogu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation Type with a parameter
 * Indicates that the annotated method is a test method that must throw the designated exception to succeed
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
