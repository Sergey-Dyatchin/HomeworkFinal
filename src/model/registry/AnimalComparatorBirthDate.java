package model.registry;

import model.animal.Animal;

import java.util.Comparator;

/**
 * Компаратор по дате дня рождения для животных
 *
 * @param <T>
 */
public class AnimalComparatorBirthDate<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
