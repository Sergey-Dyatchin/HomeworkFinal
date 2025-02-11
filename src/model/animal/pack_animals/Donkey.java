package model.animal.pack_animals;

import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Сущность животного осел
 */
public class Donkey extends PackAnimals {

    /**
     * Конструктор
     *
     */
    public Donkey(String name, Gender gender, LocalDate birthDate, List<String> listCommands, int loadCapacity) {
        super(name, gender, birthDate, listCommands, loadCapacity, "Осел");
    }
}
