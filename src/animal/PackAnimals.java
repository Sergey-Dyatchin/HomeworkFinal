package animal;

import java.util.ArrayList;
import java.util.Date;

public abstract class PackAnimals extends Animal {
    private int loadCapacity;

    PackAnimals(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, int loadCapacity) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "; load capacity:" + loadCapacity;
    }
}
