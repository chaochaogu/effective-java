package com.chaochaogu.oversync;

import com.chaochaogu.inherit.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Broken - invokes alien method from synchronized block!
 *
 * @author chaochao Gu
 * @date 2019/9/24
 */
public class ObservableSet1<E> extends ForwardingSet<E> {

    public ObservableSet1(Set<E> set) {
        super(set);
    }

    private final List<SetObserver1<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver1<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public Boolean removeObserver(SetObserver1<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    /**
     * Alien method moved outside of synchronized block - open calls
     *
     * @param element
     */
    private void notifyElementAdded(E element) {
        List<SetObserver1<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver1<E> observer : snapshot)
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
