package basicArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class BasicArrayList <T> {
    private Object[] array;
    private int size;

    private final int INITIAL_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    public BasicArrayList() {
        array = new Object[INITIAL_CAPACITY];
    }
    public BasicArrayList(int capacity) {
        if (capacity > 0) {
            array = new Object[capacity];
        } else if (capacity == 0) {
            array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
    }
    public BasicArrayList(Collection<? extends T> collection) {
        Object[] newArray = collection.toArray();
        if ((size = newArray.length) != 0) {
            array = Arrays.copyOf(newArray, size, Object[].class);
        } else {
            array = EMPTY_ARRAY;
        }
    }

    public boolean add(T element) {
        array[size] = (Object) element;
        size++;

        if (size == array.length) {
            array = expand();
        }
        return true;
    }
    public void add(int index, T element) {
        final int tempSize = size;
        Object[] newArray = array;
        if (tempSize == newArray.length)
            newArray = expand();
        System.arraycopy(newArray, index, newArray, index + 1, tempSize - index); newArray[index] = element;
        size = tempSize + 1;
    }
    public T get(int index) {
        if (index >= 0 && index < size) {
            return array(index);
        } else {
            throw new NoSuchElementException();
        }
    }
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return array(0);
        }
    }
    public T getLast() {
        int last = size - 1;
        if (last < 0) {
            throw new NoSuchElementException();
        } else {
            return array(last);
        }
    }
    public void clear() {
        for (int to = size, i = size = 0; i < to; i++) {
            array[i] = null;
        }
    }
    public void remove(int index) {
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        size--;
    }
    public int getLength() {
        return array.length;
    }
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
    private T array(int index) {
        return (T) array[index];
    }
    private Object[] expand() {
        return array = Arrays.copyOf(array, calculateNewCapacity());
    }
    private int calculateNewCapacity() {
        int oldCapacity = array.length;
        return oldCapacity + (oldCapacity >> 1);
    }
}
