package basicQuickSort;

import basicArrayList.BasicArrayList;

import java.util.*;

/**
 * BasicQuickSort принимает объект BasicArrayList и сортирует его в восходящем порядке. Все элементы в коллекции должны реализовывать интерфейс Comparable.
 * Кроме того, каждый из элементов коллекции болжны иметь возможность сравниваться друг с другом.
 */
public class BasicQuickSort {
    /**
     * Перегруженный метод quicksort для удобства пользования
     * @param array BasicArrayList, который необходимо отсортировать
     * @param <T> обязан реализовывать интерфейс Comparable
     */
    public static <T extends Comparable <T>>
    void quicksort(BasicArrayList <T> array) {
        quicksort(array, 0, array.getLength() - 1);
    }
    /**
     * Осоновной рекурсивный метод quicksort. При большом количестве рекурсивных вызовов, может вызвать переполнения стека (!).
     * В качестве pivot выбирается случайный элемент коллекции, находящийся между первым и последним элементами.
     * После чего, выбранный элемент меняется местами с последним элементом. Далее, осуществляется разделение на разделы: "меньше текущего элемента"
     * и "больше текущего эелемента", для которых рекурсивно вызывается метод quicksort
     * @param array BasicArrayList, который необходимо отсортировать
     * @param lowIndex первый элемент
     * @param highIndex последний элемент
     * @param <T> обязан реализовывать интерфейс Comparable
     */
    private static <T extends Comparable <T>>
    void quicksort(BasicArrayList <T> array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = array.get(pivotIndex);
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }
    /**
     * Разделяет переданный BasicArrayList на разделы "меньше текущего элемента" и "больше текущего эелемента":
     * если значение leftPointer равен или меньше чем pivot, то перемещаем налево от него, если больше, то перемещаем направо.
     * @param array BasicArrayList, который необходимо отсортировать
     * @param lowIndex первый элемент
     * @param highIndex последний элемент
     * @param pivot элемент, с которым происходит сравнение всех остальных элементов коллекции
     * @return элемент на котором закончили сортировать переданную коллекцию
     * @param <T>
     */
    private static <T extends Comparable <T>>
    int partition(BasicArrayList <T> array, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;

        for (int elem = lowIndex; elem < highIndex; ++elem) {
            if (array.get(elem).compareTo(pivot) <= 0) {
                swap(array, elem, leftPointer);
                leftPointer++;
            }
        }
        swap(array, highIndex, leftPointer);
        return leftPointer;
    }
    /**
     * Меняет местами элементы BasicArrayList по предоставленным индексам
     * @param array BasicArrayList в котором осуществляется перестановка элементов
     * @param firstIndex место первого элемента
     * @param secondIndex место второго элемента
     * @param <T>
     */
    private static <T>
    void swap(BasicArrayList <T> array, int firstIndex, int secondIndex) {
        T temp = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, temp);
    }
}
