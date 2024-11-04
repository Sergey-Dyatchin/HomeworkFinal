package animal;

import java.util.ArrayList;
import java.util.Date;

public class Dog extends Pets{
    private SpecializationDog specialization;

    Dog(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, boolean lovesPeople, SpecializationDog specialization) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, lovesPeople);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "; note: " + specialization;
    }
}
