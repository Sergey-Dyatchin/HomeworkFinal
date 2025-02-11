package view.menu;

import view.ConsoleView;
import view.commands.*;

import java.util.ArrayList;

/**
 * Меню выбора животного для добавления
 */
public class AddAnimalMenu extends Menu{

    public AddAnimalMenu(ConsoleView consoleView) {
        menuName = "Выбор животного:";
        commands = new ArrayList<>();
        commands.add(new Help(consoleView));
        commands.add(new AddCat(consoleView));
        commands.add(new AddDog(consoleView));
        commands.add(new AddHamster(consoleView));
        commands.add(new AddHorse(consoleView));
        commands.add(new AddDonkey(consoleView));
        commands.add(new AddCamel(consoleView));
        commands.add(new Exit(consoleView));
    }
}
