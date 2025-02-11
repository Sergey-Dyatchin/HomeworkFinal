package model.animal.pets;

import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Сущность питомца собака
 */
public class Dog extends Pets {
    /**
     * Конструктор
     *
     */
    public Dog(String name, Gender gender, LocalDate birthDate, List<String> listCommands, boolean lovesPeople) {
        super(name, gender, birthDate, listCommands, lovesPeople, "Собака");
    }
}
