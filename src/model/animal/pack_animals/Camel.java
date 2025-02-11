package model.animal.pack_animals;

import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Сущность животного верблюд
 */
public class Camel extends PackAnimals {
    /**
     * Конструктор
     *
     */
    public Camel(String name, Gender gender, LocalDate birthDate, List<String> listCommands, int loadCapacity) {
        super(name, gender, birthDate, listCommands, loadCapacity, "Верблюд");
    }
}
