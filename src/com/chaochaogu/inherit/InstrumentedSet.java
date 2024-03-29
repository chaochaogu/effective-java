package com.chaochaogu.inherit;

import java.util.Collection;
import java.util.Set;

/**
 * Wrapper class - uses composition in place of inheritance
 *
 * @author chaochao gu
 * @date 2019/8/20
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
