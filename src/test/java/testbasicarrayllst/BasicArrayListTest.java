package testbasicarrayllst;

import basicarraylist.BasicArrayList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BasicArrayListTest {
    @Test
    void createBasicArrayListWithoutProvidingCapacity() {
        BasicArrayList<Integer> basicArrayList = new BasicArrayList<>();
        final int actual = basicArrayList.getLength();
        final int expected = 10;

        assertEquals(expected, actual);
    }
    @Test
    void createBasicArrayListWithProvidingCorrectCapacity() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        final int actual = basicArrayList.getLength();
        final int expected = 5;

        assertEquals(expected, actual);
    }
    @Test
    void createBasicArrayListWithProvidingZeroCapacity() {
        final int capacity = 0;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        final int actual = basicArrayList.getLength();
        final int expected = 0;

        assertEquals(expected, actual);
    }
    @Test
    void createBasicArrayListWithProvidingNegativeCapacity() {
        final int capacity = -1;

        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new BasicArrayList<Integer>(capacity);
        });
    }
    @Test
    void createBasicArrayListFromArrayList() {
        final int capacity = 5;
        ArrayList <Integer> arrayList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            arrayList.add(5);
        }
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(arrayList);
        final Object[] actual = basicArrayList.toArray();
        final Object[] expected = new Object[] {5, 5, 5, 5, 5};

        assertArrayEquals(expected, actual);
    }
    @Test
    void convertBasicArrayListToArray() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            basicArrayList.add(5);
        }
        final Object[] actual = basicArrayList.toArray();
        final Object[] expected = new Object[] {5, 5, 5, 5, 5};

        assertArrayEquals(expected, actual);
    }
    @Test
    void setElementToTheBasicArrayList() {
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>();
        basicArrayList.add(1);
        final int index = 0;
        final Integer expected = 2;

        basicArrayList.set(index, expected);
        final Integer actual = basicArrayList.get(index);

        assertEquals(expected, actual);
    }
    @Test
    void addElementToTheBasicArrayList() {
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>();
        final boolean actual = basicArrayList.add(1);
        final boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    void addElementToTheBasicArrayListAtSpecifiedIndex() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            basicArrayList.add(5);
        }
        basicArrayList.add(2, 7);
        final Object[] actual = basicArrayList.toArray();
        final Object[] expected = new Object[] {5, 5, 7, 5, 5, 5};

        assertArrayEquals(expected, actual);
    }
    @Test
    void addAllElementsToTheBasicArrayList() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        BasicArrayList <Integer> toCopy = new BasicArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            toCopy.add(5);
        }

        basicArrayList.addAll(toCopy);
        assertArrayEquals(toCopy.toArray(), basicArrayList.toArray());
    }
    @Test
    void getElementFromBasicArrayListAtSpecifiedIndex() {
        final int capacity = 3;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        basicArrayList.add(1);
        basicArrayList.add(2);
        basicArrayList.add(3);
        final Integer actual = basicArrayList.get(1);
        final Integer expected = 2;

        assertEquals(expected, actual);
    }
    @Test
    void getFirstElementFromBasicArrayList() {
        final int capacity = 3;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        basicArrayList.add(1);
        basicArrayList.add(2);
        basicArrayList.add(3);
        final Integer actual = basicArrayList.getFirst();
        final Integer expected = 1;

        assertEquals(expected, actual);
    }
    @Test
    void getLastElementFromBasicArrayList() {
        final int capacity = 3;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        basicArrayList.add(1);
        basicArrayList.add(2);
        basicArrayList.add(3);
        final Integer actual = basicArrayList.getLast();
        final Integer expected = 3;

        assertEquals(expected, actual);
    }
    @Test
    void removeElementFromBasicArrayList() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            basicArrayList.add(5);
        }
        basicArrayList.remove(3);
        final Object[] actual = basicArrayList.toArray();
        final Object[] expected = new Object[] {5, 5, 5, 5};

        assertArrayEquals(expected, actual);
    }
    @Test
    void clearBasicArrayList() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            basicArrayList.add(5);
        }
        basicArrayList.clear();
        final Object[] actual = basicArrayList.toArray();
        final Object[] expected = new Object[] {};

        assertArrayEquals(expected, actual);
    }
}
