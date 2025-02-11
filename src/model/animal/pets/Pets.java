package model.animal.pets;

import model.animal.Animal;
import model.animal.Gender;

import java.time.LocalDate;
import java.util.List;

/**
 * Общий абстрактный класс для питомцев
 */
public abstract class Pets extends Animal {

    /**
     * Отношение к людям
     */
    private final boolean lovesPeople;

    /**
     * Конструктор
     *
     */
    protected Pets(String name, Gender gender, LocalDate birthDate, List<String> listCommands, boolean lovesPeople, String type) {
        super(name, gender, birthDate, listCommands, type);
        this.lovesPeople = lovesPeople;
    }

    @Override
    public String toString() {
        return super.toString() + (lovesPeople ? "; Любит людей." : "; Не любит людей.");
    }
}
