package model.registry;

import model.animal.Animal;

import java.util.Comparator;

/**
 * Компаратор по дате поступления в реестр для животных
 *
 * @param <T>
 */
public class AnimalComparatorReceptionDate<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getReceptionDate().compareTo(o2.getReceptionDate());
    }
}
