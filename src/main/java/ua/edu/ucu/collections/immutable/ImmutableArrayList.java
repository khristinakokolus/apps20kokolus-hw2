package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final int empty = 0;
    private Object[] immutableList;
    private int arrayListSize;


    public ImmutableArrayList() {
        this.immutableList = new Object[empty];
        this.arrayListSize = empty;
    }

    public ImmutableArrayList(Object[] array) {
        this.immutableList = array;
        this.arrayListSize = array.length;
    }


    @Override
    public ImmutableList add(Object e) {
        return add(arrayListSize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] element = {e};
        return addAll(index, element);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(arrayListSize, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        IndexException(index);
        Object[] immutableCopy;
        ImmutableArrayList newImmutableList;
        int difference;

        difference = immutableList.length - size();
        if (difference < c.length) {
            int length = c.length - difference;
            immutableCopy = new Object[immutableList.length + length];
        }
        else {
            immutableCopy = new Object[immutableList.length];
        }
        System.arraycopy(immutableList, 0, immutableCopy,
                0, index);
        System.arraycopy(c, 0, immutableCopy, index, c.length);
        System.arraycopy(immutableList, index, immutableCopy,
                index + c.length,
                arrayListSize - index);

        newImmutableList = new ImmutableArrayList(immutableCopy);
        return newImmutableList;

    }

    @Override
    public Object get(int index) {
        IndexException(index);
        Object element;
        element = immutableList[index];
        return element;
    }

    @Override
    public ImmutableList remove(int index) {
        IndexException(index);
        Object[] immutableCopy;
        ImmutableArrayList newImmutableList;

        immutableCopy = new Object[arrayListSize - 1];
        System.arraycopy(immutableList, 0, immutableCopy, 0, index);
        System.arraycopy(immutableList, index + 1, immutableCopy, index,
                immutableList.length - index - 1);

        newImmutableList = new ImmutableArrayList(immutableCopy);
        return newImmutableList;

    }

    @Override
    public ImmutableList set(int index, Object e) {
        IndexException(index);
        Object[] immutableCopy;
        ImmutableArrayList newImmutableList;

        immutableCopy = new Object[immutableList.length];
        System.arraycopy(immutableList, 0, immutableCopy,
                0, immutableList.length);
        immutableCopy[index] = e;

        newImmutableList = new ImmutableArrayList(immutableCopy);
        return newImmutableList;
    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        for (Object element : immutableList) {
            if (element.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return arrayListSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return immutableList;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    public void IndexException(int index) {
        if (size() < index || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
