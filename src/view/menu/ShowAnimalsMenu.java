package view.menu;

import view.ConsoleView;
import view.commands.*;

import java.util.ArrayList;

/**
 * Меню для отображения животных в реестре и их сортировки
 */
public class ShowAnimalsMenu extends Menu{
    public ShowAnimalsMenu(ConsoleView consoleView) {
        menuName = "Меню сортировки и отображения:";
        commands = new ArrayList<>();
        commands.add(new Help(consoleView));
        commands.add(new SortId(consoleView));
        commands.add(new SortBirthDate(consoleView));
        commands.add(new SortReceptionDate(consoleView));
        commands.add(new SortType(consoleView));
        commands.add(new CountAnimals(consoleView));
        commands.add(new Exit(consoleView));
    }
}
