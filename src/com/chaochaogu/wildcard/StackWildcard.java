package com.chaochaogu.wildcard;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * producer-extends, consumer-super（PECS）
 *
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

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // Wildcard type parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // Wildcard type parameter that serves as an E consumer
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
