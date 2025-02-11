package model.animal.pets;

import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Сущность питомца хомяк
 */
public class Hamster extends Pets {
    /**
     * Конструктор
     *
     */
    public Hamster(String name, Gender gender, LocalDate birthDate, List<String> listCommands, boolean lovesPeople) {
        super(name, gender, birthDate, listCommands, lovesPeople, "Хомяк");
    }
}
