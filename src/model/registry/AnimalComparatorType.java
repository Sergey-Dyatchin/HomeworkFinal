package model.registry;

import model.animal.Animal;

import java.util.Comparator;

/**
 * Компаратор житных для животных
 *
 * @param <T>
 */
public class AnimalComparatorType<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
