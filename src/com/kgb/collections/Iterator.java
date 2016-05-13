package com.kgb.collections;

/**
 * Created by k.betlej on 8/10/15.
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
