package somegoth;

/**
 * Сферический в вакууме класс для быстрой проверки такогой же быстрой quicksort
 * Имеет 2 параметра: имя и уровень
 */
public class Goth implements Comparable <Goth> {
    private String gothName = "";
    private int gothicLevel = 0;

    /**
     * Создаёт экземпляр класса с переданными парметрами
     * @param name имя
     * @param level уровень
     */
    public Goth(String name, int level) {
        gothName = name;
        gothicLevel = level;
    }

    /**
     * Получить имя
     * @return имя объекта
     */
    public String getGothName() {
        return gothName;
    }
    /**
     * Получить уровень
     * @return уровень объекта
     */
    public int getGothicLevel() {
        return gothicLevel;
    }
    /**
     * Предоставляет информацию об экземпляре класса
     * @return строка с именем и уровнем
     */
    public String getInfo() {
        return gothName + " with goth level of " + gothicLevel;
    }

    /**
     * Перегрузка метода для сравнения 2х экземпляров класса
     * @param goth объект с которым производится сравнение.
     * @return 0 если уровень объекта равен уровню аргумента; -1 если уровень объекта меньше уровня аргумента;
     * 1 если уровень объекта больше, чем урвоень аргумента
     */
    @Override
    public int compareTo(Goth goth) {
        return Integer.compare(this.gothicLevel, goth.gothicLevel);
    }
}
