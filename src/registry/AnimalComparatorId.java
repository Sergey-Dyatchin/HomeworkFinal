package registry;

import animal.Animal;

import java.util.Comparator;

public class AnimalComparatorId<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
}
