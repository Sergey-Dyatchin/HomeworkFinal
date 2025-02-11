package model.animal.pack_animals;

import model.animal.Animal;
import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Общий абстрактный класс для вьючных животных
 */
public abstract class PackAnimals extends Animal {
    /**
     * Грузоподъемность
     */
    private final int loadCapacity;

    /**
     * Конструктор
     *
     */
    protected PackAnimals(String name, Gender gender, LocalDate birthDate, List<String> listCommands, int loadCapacity, String type) {
        super(name, gender, birthDate, listCommands, type);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "; Грузоподъемность: " + loadCapacity + "кг.";
    }
}
