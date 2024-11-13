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
     * Сравнение объекта по отношению к которому вызывается метод с тем объектом,
     * который передаётся в качестве аргумента данного метода
     * @param object объект с которым производится сравнение
     * @return true - если объекты равны, false - если объекты не равны
     */
    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof Goth other)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        boolean nameEquals = (this.gothName == null && other.gothName == null)
                || (this.gothName != null && this.gothName.equals(other.gothName));
        boolean levelEquals = (this.gothicLevel == other.gothicLevel);
        return nameEquals && levelEquals;
    }
    /**
     * Вычисление хеш-кода для объекта класса
     * @return хеш-код объекта
     */
    public int hashCode() {
        int result = gothName != null ? gothName.hashCode() : 0;
        result = 31 * result + gothicLevel;
        return result;
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
