package com.kgb.collections;

/**
 * Created by k.betlej on 8/10/15.
 */
public interface Collection<T> {
    int size();

    Iterator<T> getIterator();

    T[] toArray();

    void clear();
    void addAll(Collection<T> collection);
}
