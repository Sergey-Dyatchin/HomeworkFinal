package animal;

import java.util.ArrayList;
import java.util.Date;

public class Camel extends PackAnimals{
    private HumpsCamel hump;

    Camel(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, int loadCapacity, HumpsCamel hump) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, loadCapacity);
        this.hump = hump;
    }

    @Override
    public String toString() {
        return super.toString() + "; note: humps" + hump;
    }
}
