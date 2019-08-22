package com.chaochaogu.interfacer;

import java.util.Map;
import java.util.Objects;

/**
 * skeletal implementation class
 *
 * @author chaochao Gu
 * @date 2019/8/22
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

    // Entries in a midifiable map must override this method
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Implements the general constract of Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    // Implements the general constract of Map.Entry.equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractMapEntry)) {
            return false;
        }
        Map.Entry e = (Map.Entry) obj;
        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    @Override
    public String toString() {
        return getKey() + "" + getValue();
    }
}
