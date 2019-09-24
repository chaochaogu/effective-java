package com.chaochaogu.oversync;

/**
 * @author chaochao Gu
 * @date 2019/9/24
 */
@FunctionalInterface
public interface SetObserver2<E> {
    /**
     * Invoked when an element is added to the observable set
     *
     * @param set
     * @param element
     */
    void added(ObservableSet2<E> set, E element);
}
