package com.chaochaogu.clone;

/**
 * Recursive clone method for class with complex mutable state
 *
 * @author chaochao gu
 * @date 2019/8/17
 */
public class HashTable implements Cloneable {

    private Entry[] buckets = null;

    private class Entry {

        final Object key;

        Object value;

        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively copy the linked list headed by this Entry
        /*Entry deepCopy() {
            return new Entry(key, value, value == null ? null : next.deepCopy());
        }*/

        // Iteratively copy the linked list headed by this Entry
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }

        @Override
        public HashTable clone() {
            try {
                HashTable result = (HashTable) super.clone();
                result.buckets = new Entry[buckets.length];
                for (int i = 0; i < buckets.length; i++) {
                    if (buckets[i] != null) {
                        result.buckets[i] = buckets[i].deepCopy();
                    }
                }
                return result;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
