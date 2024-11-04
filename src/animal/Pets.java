package animal;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pets extends Animal{
    private boolean lovesPeople;

    Pets(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type, boolean lovesPeople) {
        super(id, name, gender, birthDate, receptionDate, listCommands, type);
        this.lovesPeople = lovesPeople;
    }

    @Override
    public String toString() {
        return super.toString() + (lovesPeople? "; loves People":"; doesn't like people");
    }
}
