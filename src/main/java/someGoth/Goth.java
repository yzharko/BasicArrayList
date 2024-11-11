package someGoth;

/**
 * Сферический в вакууме класс для быстрой проверки такогой же быстрой quicksort
 * Имеет 2 параметра: имя и уровень
 */
public class Goth implements Comparable <Goth> {
    private String gothName_ = "";
    private int gothicLevel_ = 0;

    /**
     * Создаёт экземпляр класса с переданными парметрами
     * @param gothName имя
     * @param gothicLevel уровень
     */
    public Goth(String gothName, int gothicLevel) {
        gothName_ = gothName;
        gothicLevel_ = gothicLevel;
    }

    /**
     * Получить имя
     * @return имя объекта
     */
    public String getGothName() {
        return gothName_;
    }
    /**
     * Получить уровень
     * @return уровень объекта
     */
    public int getGothicLevel() {
        return gothicLevel_;
    }
    /**
     * Предоставляет информацию об экземпляре класса
     * @return строка с именем и уровнем
     */
    public String getInfo() {
        return gothName_ + " with goth level of " + gothicLevel_;
    }

    /**
     * Перегрузка метода для сравнения 2х экземпляров класса
     * @param goth объект с которым производится сравнение.
     * @return 0 если уровень объекта равен уровню аргумента; -1 если уровень объекта меньше уровня аргумента;
     * 1 если уровень объекта больше, чем урвоень аргумента
     */
    @Override
    public int compareTo(Goth goth) {
        if (this.gothicLevel_ == goth.gothicLevel_) {
            return 0;
        } else if (this.gothicLevel_ < goth.gothicLevel_) {
            return -1;
        } else {
            return 1;
        }
    }
}
