package com.chaochaogu.oversync;

import com.chaochaogu.inherit.ForwardingSet;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Broken - invokes alien method from synchronized block!
 *
 * @author chaochao Gu
 * @date 2019/9/24
 */
public class ObservableSet2<E> extends ForwardingSet<E> {

    public ObservableSet2(Set<E> set) {
        super(set);
    }

    /**
     * Thread-safe observable set with CopyOnWriteArrayList
     */
    private final List<SetObserver2<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver2<E> observer) {
        observers.add(observer);
    }

    public Boolean removeObserver(SetObserver2<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserver2<E> observer : observers)
            observer.added(this, element);
    }

    @Override
    public boolean add(E element) {
        Boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Boolean result = false;
        for (E element : c)
            result |= add(element);
        // Calls notifyElementAdded
        return result;
    }
}
