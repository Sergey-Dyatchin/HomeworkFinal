package view.menu;

import view.ConsoleView;
import view.commands.*;

import java.util.ArrayList;

/**
 * Главное меню программы
 */
public class StartMenu extends Menu {

    public StartMenu(ConsoleView consoleView) {
        menuName = "Главное меню:";
        commands = new ArrayList<>();
        commands.add(new Help(consoleView));
        commands.add(new Save(consoleView));
        commands.add(new Load(consoleView));
        commands.add(new AddAnimal(consoleView));
        commands.add(new ShowAnimals(consoleView));
        commands.add(new AddCommand(consoleView));
        commands.add(new Exit(consoleView));
    }
}
