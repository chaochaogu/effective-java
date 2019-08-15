package com.chaochaogu.memoryleak;

/**
 * @author chaochao gu
 * @date 2019/8/15
 */
public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("s");
        stack.push(1);
        stack.push(2L);
        stack.push(true);
        Object pop1 = stack.pop();
        Object pop2 = stack.pop();
        Object pop3 = stack.pop();
        Object pop4 = stack.pop();
        Object pop5 = stack.pop();
    }
}
