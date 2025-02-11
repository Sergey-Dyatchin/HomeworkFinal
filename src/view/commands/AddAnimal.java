package view.commands;

import view.ConsoleView;

/**
 * Вызывает меню добавления животного
 */
public class AddAnimal extends Command{

    public AddAnimal(ConsoleView consoleView) {
        super("Добавить животное ->", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addAnimal();
    }
}

