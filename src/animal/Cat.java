package animal;

import java.util.ArrayList;
import java.util.Date;

public class Cat extends Pets{
    private HairCat hair;

    Cat(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, boolean lovesPeople, HairCat hair) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, lovesPeople);
        this.hair = hair;
    }
    @Override
    public String toString() {
        return super.toString() + "; note: " + hair;
    }
}
