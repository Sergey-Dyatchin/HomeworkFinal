package animal;

import java.util.ArrayList;
import java.util.Date;

public class Hamster extends Pets{
    private String favoriteToy;

    Hamster(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, boolean lovesPeople, String favoriteToy) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, lovesPeople);
        this.favoriteToy = favoriteToy;
    }

    @Override
    public String toString() {
        return super.toString() + "; note: favorite toy is a " + favoriteToy;
    }
}
