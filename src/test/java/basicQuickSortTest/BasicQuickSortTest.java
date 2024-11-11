package basicQuickSortTest;

import basicArrayList.BasicArrayList;
import basicQuickSort.BasicQuickSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BasicQuickSortTest {
    @Test
    public void basicQuickSortForBasicArrayListOfIntegers() {
        final int capacity = 10;
        ArrayList <Integer> arrayList = new ArrayList<>(capacity);
        Random rand = new Random();

        for (int i = 0; i < capacity; ++i) {
            arrayList.add(rand.nextInt(100));
        }
        BasicArrayList <Integer> basicArrayList = new BasicArrayList<>(arrayList);

        Collections.sort(arrayList);
        BasicQuickSort.quicksort(basicArrayList);

        assertArrayEquals(arrayList.toArray(), basicArrayList.toArray());
    }
    @Test
    public void basicQuickSortForBasicArrayListOfDoubles() {
        final int capacity = 10;
        ArrayList <Double> arrayList = new ArrayList<>(capacity);
        Random rand = new Random();

        for (int i = 0; i < capacity; ++i) {
            arrayList.add(rand.nextDouble());
        }
        BasicArrayList <Double> basicArrayList = new BasicArrayList<>(arrayList);

        Collections.sort(arrayList);
        BasicQuickSort.quicksort(basicArrayList);

        assertArrayEquals(arrayList.toArray(), basicArrayList.toArray());
    }
}
