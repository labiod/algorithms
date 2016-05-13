package com.kgb.collections;

/**
 * Created by k.betlej on 8/24/15.
 */
public class Heap<T extends Comparable<T>> implements Collection<T> {
    private class HeapNode<E extends Comparable<E>> {
        private int mLevelCounting = 0;
        private E mItem;
        private int mLevel;
        private HeapNode<E> mLeftChild = null;
        private HeapNode<E> mRightChild = null;
        HeapNode(E item) {
            mItem = item;
            mLevel = 1;
        }

        void addChild(HeapNode<E> child) {
            addChild(child, 1);
        }

        private boolean addChild(HeapNode<E> child, int level) {
            if(level > mHeight) {
                return false;
            }
            if(getItem().compareTo(child.getItem()) == 1) {
                if(mLeftChild == null) {
                    mLeftChild = child;
                    mLeftChild.mLevel = mLevel+1;
                    mLevelCounting++;
                    mLength++;
                } else if(mRightChild == null) {
                    mRightChild = child;
                    mRightChild.mLevel = mLevel+1;
                    mLength++;
                    mLevelCounting++;
                    if(mLevelCounting == Math.pow(2, mHeight) ) {
                        mHeight++;
                        mLevelCounting = 0;
                    }
                } else {
                    boolean isAdded = mLeftChild.addChild(child, level+1);
                    if(!isAdded) {
                        mRightChild.addChild(child, level+1);
                    }
                }
            } else {
                E item = getItem();
                mItem = child.getItem();
                child.mItem = item;
                addChild(child, level);
            }
            return true;
        }

        boolean hasChildren() {
            return mLeftChild != null || mRightChild != null;
        }

        E getItem() {
            return mItem;
        }

        int getLength() {
            return mLength;
        }

        Object[] toArray() {
            Object[] elements = new Object[getLength()];
            for(int i =0; i < getLength(); ++i) {
                elements[i] = mRoot.getChild(i).getItem();
            }
            return elements;
        }

        HeapNode<E> getChild(int index) {
            return this;
        }

        @Override
        public String toString() {
            return mItem.toString();
        }
    }
    private class Iter implements Iterator<T> {
        private Object[] mElements;
        private int mIndex = 0;

        Iter() {
            mElements = mRoot.toArray();
        }
        @Override
        public boolean hasNext() {
            return mIndex < mElements.length;
        }

        @Override
        public T next() {
            return (T) mElements[mIndex++];
        }

        @Override
        public void remove() {
            throw new RuntimeException("Iterator don't provider removing item from heap");
        }
    }

    private int mLength = 1;
    private int mHeight = 1;
    private HeapNode<T> mRoot;

    public void add(T item) {
        if(mRoot == null) {
            mRoot = new HeapNode<T>(item);
        } else {
            mRoot.addChild(new HeapNode<T>(item));
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> getIterator() {
        return new Iter();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public void addAll(Collection<T> collection) {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[ ");

        Object[] elements = mRoot.toArray();
        for(int i =0; i < elements.length; ++i) {
            builder.append(elements[i]);
            if(i < elements.length - 1) {
                builder.append(", ");
            }
        }
        builder.append(" ]");
        return builder.toString();
    }
}
