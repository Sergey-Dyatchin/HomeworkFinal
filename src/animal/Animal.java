package animal;

import java.util.ArrayList;
import java.util.Date;

public abstract class Animal {
    final private int id;
    private String name;
    final private Gender gender;
    final private Date birthDate;
    final private Date receptionDate;
    private ArrayList<String> listCommands;
    final private String type;

    Animal(int id, String name, Gender gender, Date birthDate, Date receptionDate, ArrayList<String> listCommands, String type) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.receptionDate = receptionDate;
        this.listCommands = listCommands;
        this.type = type;
    }


    public String getCommands() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listCommands.size(); i++) {
            stringBuilder.append(listCommands.get(i));
            if (i < listCommands.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public void addCommand(String command) {
        listCommands.add(command);
    }

    @Override
    public String toString() {
        return "Id: " + id + "; type: " + type + "; name: " + name + "; gender: " + gender + "; birth date: " + birthDate +
                "; reception date: " + receptionDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }
}
