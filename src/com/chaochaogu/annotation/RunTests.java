package com.chaochaogu.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Program to process marker annotations
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class RunTests {

    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.chaochaogu.annotation.Sample");
        Method[] methods = testClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + "failed" + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test" + m);
                }
            }
        }
        System.out.printf("passed : %d, Failed : %d%n", passed, tests - passed);
    }

    private static void test2() throws Exception {

        int tests = 0;
        int passed = 0;
        Class<?> testExceptionClass = Class.forName("com.chaochaogu.annotation.Sample2");
        Method[] methods = testExceptionClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed : no exception", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }

    }

    private static void test3() throws Exception {

        int tests = 0;
        int passed = 0;
        Class<?> testException1Class = Class.forName("com.chaochaogu.annotation.Sample3");
        Method[] methods = testException1Class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ExceptionTest1.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed : no exception", m);
                } catch (InvocationTargetException wrappedExc) {
                    int oldPassed = passed;
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTest1.class).value();
                    for (Class excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (oldPassed == passed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }

    }

    private static void test4() throws Exception {

        int tests = 0;
        int passed = 0;
        Class<?> testException1Class = Class.forName("com.chaochaogu.annotation.Sample4");
        Method[] methods = testException1Class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ExceptionTest2.class) || m.isAnnotationPresent(ExceptionTest2Container.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed : no exception", m);
                } catch (InvocationTargetException wrappedExc) {
                    int oldPassed = passed;
                    Throwable exc = wrappedExc.getCause();
                    ExceptionTest2[] exceptionTest2s = m.getAnnotationsByType(ExceptionTest2.class);
                    for (ExceptionTest2 exceptionTest2 : exceptionTest2s) {
                        if (exceptionTest2.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (oldPassed == passed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }

    }
}
