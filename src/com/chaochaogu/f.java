package com.chaochaogu;

/**
 * @author chaochao Gu
 * @date 2019/8/16
 */
public class f {
    static Integer count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                synchronized (count){
                    count++;
                }
            }).start();
        }
        System.out.println(count);
    }
}
