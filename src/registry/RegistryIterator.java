package registry;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistryIterator<Animal> implements Iterator<Animal> {

    private ArrayList<Animal> animalList;
    private int index;

    public RegistryIterator(ArrayList<Animal> animalList) {
        this.animalList = animalList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < animalList.size();
    }

    @Override
    public Animal next() {
        return animalList.get(index++);
    }
}
