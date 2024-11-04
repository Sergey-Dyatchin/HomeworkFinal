package animal;

import java.util.ArrayList;
import java.util.Date;

public class Horse extends PackAnimals{
    private int maxSpeed;

    Horse(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, int loadCapacity, int maxSpeed) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, loadCapacity);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + "; note: maximum speed " + maxSpeed + "km/h";
    }
}
