package view.menu;

import view.ConsoleView;
import view.commands.*;

import java.util.ArrayList;

/**
 * Меню добавление команды, позволяет выбрать:
 * добавление новой команды в реестр или
 * добавление существующих команд животному
 */
public class AddCommandMenu extends Menu{
    public AddCommandMenu(ConsoleView consoleView) {
        menuName = "Меню добавления команд:";
        commands = new ArrayList<>();
        commands.add(new Help(consoleView));
        commands.add(new AddCommandRegister(consoleView));
        commands.add(new AddCommandAnimal(consoleView));;
        commands.add(new Exit(consoleView));
    }
}