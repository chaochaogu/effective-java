package com.chaochaogu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation type declaration
 * Indicates that the annotated method is a test method, use only on parameterless static methods
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}
