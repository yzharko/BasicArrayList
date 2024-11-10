package basicQuickSortTest;

import basicQuickSort.BasicQuickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BasicQuickSortTest {
    @Test
    public void basicQuickSortForArrayOfIntegers() {
        final int capacity = 10;
        Integer[] array = new Integer[capacity];
        Random rand = new Random();

        for (int i = 0; i < capacity; ++i) {
            array[i] = rand.nextInt(10);
        }

        Integer[] yaArray = new Integer[capacity];
        System.arraycopy(array, 0, yaArray, 0, capacity);

        BasicQuickSort.quicksort(array);
        Arrays.sort(yaArray);
        assertArrayEquals(yaArray, array);
    }
}
