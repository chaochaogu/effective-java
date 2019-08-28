package com.chaochaogu.heterogeneouscontainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * Typesafe heterogeneous container pattern - client
 *
 * @author chaochao Gu
 * @date 2019/8/28
 */
public class Main {

    public static void main(String[] args) {

        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        Integer favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }

    // 在编译时读取类型未知的注解
    // Use of asSubclass to safety cast to a bounded type token
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}
