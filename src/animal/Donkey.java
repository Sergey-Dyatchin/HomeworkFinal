package animal;

import java.util.ArrayList;
import java.util.Date;

public class Donkey extends PackAnimals {
    private TypeDonkey typeDonkey;

    Donkey(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, int loadCapacity, TypeDonkey typeDonkey) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type, loadCapacity);
        this.typeDonkey = typeDonkey;
    }

    @Override
    public String toString() {
        return super.toString() + "; note: " + typeDonkey;
    }
}
