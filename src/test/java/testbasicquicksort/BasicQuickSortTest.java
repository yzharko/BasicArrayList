package testbasicquicksort;

import basicarraylist.BasicArrayList;
import basicquicksort.BasicQuickSort;
import org.junit.jupiter.api.Test;
import somegoth.Goth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BasicQuickSortTest {
    @Test
    void basicQuickSortForBasicArrayListOfIntegers() {
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
    void basicQuickSortForBasicArrayListOfDoubles() {
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
    @Test
    void basicQuickSortForBasicArrayListOfGoths() {
        final int capacity = 2;
        final Goth goth = new Goth("Cheburashka", 12);
        final Goth yaGoth = new Goth("Gena", 150);

        ArrayList <Goth> arrayList = new ArrayList<>(capacity);
        arrayList.add(yaGoth);
        arrayList.add(goth);
        BasicArrayList <Goth> basicArrayList = new BasicArrayList<>(arrayList);

        Collections.sort(arrayList);
        BasicQuickSort.quicksort(basicArrayList);

        assertArrayEquals(arrayList.toArray(), basicArrayList.toArray());
    }
}
