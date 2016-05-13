package com.kgb.collections;

import com.kgb.collections.sort.Sorting;

import java.lang.reflect.Array;

/**
 * Created by k.betlej on 9/15/15.
 */
public class Collections {
    public static <T extends Comparable<T>> void sort(Collection<T> collection) {
        T[] table = collection.toArray();
        if(collection.size() < 10) {
            Sorting.insertionSort(table);
        } else {
            Sorting.quickSort(table);
        }
        collection.clear();
        collection.addAll(Collections.arrayToList(table));
    }

    private static <T extends Comparable<T>> Collection<T> arrayToList(T[] table) {
        List<T> list = new List<T>();
        for(int i =0; i < table.length; ++i) {
            list.add(table[i]);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static<T> T[] arrayCopy(T[] original, int length) {
        return (T[]) copyOf(original, length, original.getClass());
    }

    @SuppressWarnings("unchecked")
    private static<T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        T[] copy = ((Object)newType == (Object)Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }
}
