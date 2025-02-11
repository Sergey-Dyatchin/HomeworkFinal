package model.registry;

import model.animal.Animal;

import java.util.Comparator;

/**
 * Компаратор по Id для животных
 *
 * @param <T>
 */
public class AnimalComparatorId<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
