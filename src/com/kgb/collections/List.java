package com.kgb.collections;

import java.lang.reflect.Array;

/**
 * Created by k.betlej on 9/15/15.
 */
public class List<T> implements Collection<T> {
    private class ListIterator<E> implements Iterator<E> {
        int currItemIndex = -1;
        @Override
        public boolean hasNext() {
            return currItemIndex + 1 < mListLength;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            currItemIndex++;
            return (E) mTable[currItemIndex];
        }

        @Override
        public void remove() {

        }
    }

    private static final int LIST_EXTEND_VALUE = 8;
    private int mListLength = 0;
    private T[] mTable;

    public List() {
    }

    public List(Collection<T> list) {
        addAll(list);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(mListLength > index) {
            return mTable[index];
        }
        return null;
    }
    public void add (T item) {
        if(mTable == null) {
            createStartTable(LIST_EXTEND_VALUE, item.getClass());
        } else if(mTable.length == mListLength) {
            extendTable();
        }
        mTable[mListLength++] = item;
    }

    public void remove(int index) {

        for(int i = index; i < mListLength - 1; ++i) {
            mTable[i] = mTable[i + 1];
        }
        mListLength--;
        mTable[mListLength] = null;
    }

    @Override
    public int size() {
        return mListLength;
    }

    @Override
    public Iterator<T> getIterator() {
        return new ListIterator<T>();
    }

    @Override
    public T[] toArray() {
        return Collections.arrayCopy(mTable, mListLength);
    }

    @Override
    public void clear() {
        mListLength = 0;
        mTable = null;
    }

    @Override
    public void addAll(Collection<T> list) {
        T[] table = list.toArray();
        if(table.length > 0) {
            createStartTable(table.length, table[0].getClass());
            Iterator<T> iterator = list.getIterator();
            while (iterator.hasNext()) {
                mTable[mListLength++] = iterator.next();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for(int i = 0; i < mListLength - 1; ++i) {
            builder.append(mTable[i]).append(", ");
        }
        builder.append(mTable[mListLength - 1]).append(" ]");
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    private void extendTable() {
        T[] newTable = (T[]) Array.newInstance(mTable[0].getClass(), mTable.length * 2);
        System.arraycopy(mTable, 0, newTable, 0, mListLength);
        mTable = newTable;
    }

    @SuppressWarnings("unchecked")
    private void createStartTable(int length, Class<?> tableClass) {

        mTable = (T[]) Array.newInstance(tableClass, length);
    }
}
