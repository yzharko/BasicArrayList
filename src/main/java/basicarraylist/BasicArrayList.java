package basicarraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Непотокобезопасная реализация сомнительного аналога ArrayList, реализующая интерфейс BasicList.
 * Предоставляет пользователю набор методов по добавлению, получению, изменению, удалению и очистке элементов.
 */
public class BasicArrayList <T> implements BasicList <T> {
    private Object[] array;
    private int size;

    private final int INITIAL_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    /**
     * Создание коллекции объектов на 10 элементов
     */
    public BasicArrayList() {
        array = new Object[INITIAL_CAPACITY];
    }
    /**
     * Создание коллекцию объектов с заданным количеством элементов
     * @param capacity емкость создаваемого массива
     */
    public BasicArrayList(int capacity) {
        if (capacity > 0) {
            array = new Object[capacity];
        } else if (capacity == 0) {
            array = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
    }
    /**
     * Создание коллекцию объектов из переданного экземпляра другой коллекции
     * @param collection коллекция, которая будет скопирована
     */
    public BasicArrayList(Collection<? extends T> collection) {
        Object[] newArray = collection.toArray();
        if ((size = newArray.length) != 0) {
            array = Arrays.copyOf(newArray, size, Object[].class);
        } else {
            array = EMPTY_ARRAY;
        }
    }
    /**
     * Добавление элемента в коллекцию
     * @param element элемент, добавляемый в коллекцию
     * @return true при успешной вставке
     */
    @Override
    public boolean add(T element) {
        array[size] = (Object) element;
        size++;

        if (size == array.length) {
            array = expand();
        }
        return true;
    }
    /**
     * Добавление элемента в коллекцию по указанному индексу
     * @param index место на которое будет добавлен элемент
     * @param element элемент, добавляемый в коллекцию
     * @return true при успешной вставке
     */
    @Override
    public boolean add(int index, T element) {
        final int tempSize = size;
        Object[] newArray = array;
        if (tempSize == newArray.length) {
            newArray = expand();
        }
        System.arraycopy(newArray, index, newArray, index + 1, tempSize - index); newArray[index] = element;
        size = tempSize + 1;
        return true;
    }
    /**
     * Добавление всех элементов BasicArrayList в уже существующий BasicArrayList
     * @param newArray BasicArrayList элементы которого будут добавлены
     * @return true при успешной вставке, false при передаче пустого BasicArrayList
     */
    public boolean addAll(BasicArrayList newArray) {
        int newSize = newArray.size;
        if (newSize == 0)
            return false;
        Object[] elementData = array;
        final int tempSize = size;
        if (newSize > elementData.length - tempSize)
            elementData = expand();
        System.arraycopy(newArray.array, 0, elementData, tempSize, newSize);
        size = tempSize + newSize;
        return true;
    }
    /**
     * Получение элемента по указанному индексу
     * @param index место из которого будет получен элемент
     * @throws NoSuchElementException при отсутствии указанного индекса
     * @return элемент коллекции с указанным индексом
     */
    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return array(index);
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Получение первого элемента коллекции
     * @return первый элемент коллекции
     * @throws NoSuchElementException при пустой коллекции
     */
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return array(0);
        }
    }
    /**
     * Получение последнего элемента коллекции
     * @return последний элемент коллекции
     * @throws NoSuchElementException некорректном индексе
     */
    public T getLast() {
        int last = size - 1;
        if (last < 0) {
            throw new NoSuchElementException();
        } else {
            return array(last);
        }
    }

    /**
     * Замена элемента по указанному индексу на новый
     * @param index место элемента, который будет заменён
     * @param element новый элемент
     * @return заменённый элемент
     * @throws NoSuchElementException при отсутствии указанного индекса
     */
    @Override
    public T set(int index, T element) {
        if (index >= 0 && index < size) {
            T oldValue = array(index);
            array[index] = element;
            return oldValue;
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Очищение текущей коллекции
     */
    @Override
    public void clear() {
        for (int to = size, i = size = 0; i < to; i++) {
            array[i] = null;
        }
    }
    /**
     * Удаление элемента коллекции по указанному индексу
     * @param index место из которого будет удалён элемент
     */
    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; ++i) {
            array[i] = array[i + 1];
        }
        size--;
    }
    /**
     * Получение длины текущей коллекции
     * @return длина коллекции
     */
    public int getLength() {
        return array.length;
    }
    /**
     * Преобразование текущей коллекции в массив объектов
      * @return массив объектов
     */
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
    /**
     * Получение элемента по указанному индексу
     * @param index место из которого будет получен элемент
     * @return элемент коллекции с указанным индексом
     */
    private T array(int index) {
        return (T) array[index];
    }
    /**
     * Расширение длины коллекции
     * @return Расширенная коллекция
     */
    private Object[] expand() {
        return Arrays.copyOf(array, calculateNewCapacity());
    }
    /**
     * Вычисление новой длины коллекции
     * @return новая длина коллекции
     */
    private int calculateNewCapacity() {
        int oldCapacity = array.length;
        return oldCapacity + (oldCapacity >> 1);
    }
}
