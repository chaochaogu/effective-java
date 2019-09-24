package com.chaochaogu.oversync;

/**
 * @author chaochao Gu
 * @date 2019/9/24
 */
@FunctionalInterface
public interface SetObserver<E> {
    /**
     * Invoked when an element is added to the observable set
     *
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set, E element);
}
