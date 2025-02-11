package model.animal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Общий абстрактный класс для всех животных
 */
public abstract class Animal implements Serializable {
    /**
     * Идентификатор каждый раз присваивается увеличенный на 1 начиная с 1.
     */
    private int id;

    /**
     * Имя животного
     */
    private final String name;

    /**
     * Пол животного Enum(перечисление)
     */
    private final Gender gender;

    /**
     * Дата рождения
     */
    private final LocalDate birthDate;

    /**
     * Дата поступления формируется из текущей при создании объекта
     */
    private final LocalDate receptionDate;

    /**
     * Команды, которые знает животное
     */
    private final List<String> listCommands;

    /**
     * Вид присваивается в зависимости от класса
     */
    private final String type;

    /**
     * Конструктор
     *
     */
    protected Animal(String name, Gender gender, LocalDate birthDate, List<String> listCommands, String type) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.receptionDate = LocalDate.now();
        this.listCommands = listCommands;
        this.type = type;
    }

    // region Сеттеры и Геттеры
    public List<String> getCommands() {
        return listCommands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public String getType() {
        return type;
    }
    // endregion

    /**
     * Добавляет список команд к существующим у животного
     *
     * @param commands  List<String> список команд
     */
    public void addCommands(List<String> commands) {
        listCommands.addAll(commands);
    }

    @Override
    public String toString() {
        StringBuilder commands = new StringBuilder();
        if (!listCommands.isEmpty()) {
            commands.append("; Знает команды: ");
            for (String command : listCommands) {
                commands.append(command);
                commands.append(", ");
            }
            commands.deleteCharAt(commands.length() - 1).deleteCharAt(commands.length() - 1);
        } else {
            commands.append("; Не знает команд");
        }
        return id + ". " + type + "; Имя: " + name + "; Пол: " + gender + "; Дата рождения: " + birthDate + "; Дата поступления: " + receptionDate + commands;
    }


}
