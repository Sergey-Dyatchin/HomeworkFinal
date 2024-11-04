package registry;

import animal.Animal;

import java.util.Comparator;

public class AnimalComparatorName<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getReceptionDate().compareTo(o2.getReceptionDate());
    }
}
