package com.chaochaogu.memoryleak;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Can you spot the "memory leak"?
 * @author chaochao gu
 * @date 2019/8/15
 */
public class Stack {

    private Object[] elements;

    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 3;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        // Eliminate obsolete reference
        elements[size] = null;
        return result;
    }

    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity(){
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
