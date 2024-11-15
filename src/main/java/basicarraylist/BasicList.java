package basicarraylist;

/**
 *Интерфейс указывает базовые требования для реализации в виде:
 * добавления элемента, добавления элемента по индексу, получение элемента по индексу,
 * изменение элемента по указанному индексу на новый, очищение коллекции,
 * удаления элемента по указанному индексу
 * @param <T>
 */
public interface BasicList <T> {
    /**
     * Добавление элемента в коллекцию
     * @param elem элемент, добавляемый в коллекцию
     * @return true при успешной вставке
     */
    boolean add(T elem);
    /**
     * Добавление элемента в коллекцию по указанному индексу
     * @param index место на которое будет добавлен элемент
     * @param elem элемент, добавляемый в коллекцию
     * @return true при успешной вставке
     */
    boolean add(int index, T elem);
    /**
     * Получение элемента по указанному индексу
     * @param index место из которого будет получен элемент
     * @return элемент коллекции с указанным индексом
     */
    T get(int index);
    /**
     * Замена элемента по указанному индексу на новый
     * @param index место элемента, который будет заменён
     * @param element новый элемент
     * @return заменённый элемент
     */
    T set(int index, T element);
    /**
     * Очищение текущей коллекции
     */
    void clear();
    /**
     * Удаление элемента коллекции по указанному индексу
     * @param index место из которого будет удалён элемент
     */
    void remove(int index);
}
