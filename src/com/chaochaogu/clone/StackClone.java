package com.chaochaogu.clone;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author chaochao gu
 * @date 2019/8/17
 */
public class StackClone {

    private Object[] elements;

    private int size;

    private static final int DEFAULT_SIZE = 3;

    public StackClone() {
        this.elements = new Object[DEFAULT_SIZE];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    public void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    // Clone method for class with references to mutable state
    @Override
    protected Object clone() {
        try {
            StackClone result = (StackClone) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
