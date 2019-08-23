package com.chaochaogu.generictype;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author chaochao Gu
 * @date 2019/8/23
 */
public class StackWildcard<E> {

    private E[] elements;

    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public StackWildcard() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }


}
