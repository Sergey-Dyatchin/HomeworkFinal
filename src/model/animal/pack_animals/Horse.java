package model.animal.pack_animals;

import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Сущность животного лошадь
 */
public class Horse extends PackAnimals {

    /**
     * Конструктор
     *
     */
    public Horse(String name, Gender gender, LocalDate birthDate, List<String> listCommands, int loadCapacity) {
        super(name, gender, birthDate, listCommands, loadCapacity, "Лошадь");
    }
}
