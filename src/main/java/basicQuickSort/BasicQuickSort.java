package basicQuickSort;

import basicArrayList.BasicArrayList;

import java.util.*;

public class BasicQuickSort {
    public static <T extends Comparable <T>>
    void quicksort(T[] array) {
        quicksort(array, 0, array.length - 1);
    }
    private static <T extends Comparable <T>>
    void quicksort(T[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }
    private static <T extends Comparable <T>>
    int partition(T[] array, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;

        for (int elem = lowIndex; elem < highIndex; ++elem) {
            if (array[elem].compareTo(pivot) <= 0) {
                swap(array, elem, leftPointer);
                leftPointer++;
            }
        }
        swap(array, highIndex, leftPointer);
        return leftPointer;
    }
    private static <T>
    void swap(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
