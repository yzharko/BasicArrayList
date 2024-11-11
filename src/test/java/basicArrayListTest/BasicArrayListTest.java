package basicArrayListTest;

import basicArrayList.BasicArrayList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BasicArrayListTest {
    @Test
    public void createBasicArrayListWithoutProvidingCapacity() {
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>();
        final int actual = basicArrayList.getLength();
        final int expected = 10;

        assertEquals(expected, actual);
    }
    @Test
    public void createBasicArrayListWithProvidingCorrectCapacity() {
        final int capacity = 5;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        final int actual = basicArrayList.getLength();
        final int expected = 5;

        assertEquals(expected, actual);
    }
    @Test
    public void createBasicArrayListWithProvidingZeroCapacity() {
        final int capacity = 0;
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(capacity);
        final int actual = basicArrayList.getLength();
        final int expected = 0;

        assertEquals(expected, actual);
    }
    @Test
    public void createBasicArrayListWithProvidingNegativeCapacity() {
        final int capacity = -1;

        assertThrowsExactly(IllegalArgumentException.class, () -> {
            BasicArrayList<Integer> basicArrayList = new BasicArrayList<>(capacity);
        });
    }
    @Test
    public void createBasicArrayListFromArrayList() {
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
    public void convertBasicArrayListToArray() {
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
    public void setElementToTheBasicArrayList() {
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>();
        basicArrayList.add(1);
        final int index = 0;
        final Integer expected = 2;

        basicArrayList.set(index, expected);
        final Integer actual = basicArrayList.get(index);

        assertEquals(expected, actual);
    }
    @Test
    public void addElementToTheBasicArrayList() {
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>();
        final boolean actual = basicArrayList.add(1);
        final boolean expected = true;

        assertEquals(expected, actual);
    }
    @Test
    public void addElementToTheBasicArrayListAtSpecifiedIndex() {
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
    public void addAllElementsToTheBasicArrayList() {
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
    public void getElementFromBasicArrayListAtSpecifiedIndex() {
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
    public void getFirstElementFromBasicArrayList() {
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
    public void getLastElementFromBasicArrayList() {
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
    public void removeElementFromBasicArrayList() {
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
    public void clearBasicArrayList() {
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
