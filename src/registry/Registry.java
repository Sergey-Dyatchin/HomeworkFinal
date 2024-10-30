package registry;

import animal.Animal;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Animal> animalList;
    private ArrayList<String> existingCommandList;

    Registry() {
        animalList = new ArrayList<>();
        existingCommandList = new ArrayList<>();

        existingCommandList.add("Sit");
        existingCommandList.add("Down");
        existingCommandList.add("Jump");
        existingCommandList.add("Stay");
        existingCommandList.add("Walk");
        existingCommandList.add("Run");
    }

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    public void addNewCommand(String command){
        existingCommandList.add(command);;
    }

}

