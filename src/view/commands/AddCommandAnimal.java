package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления команд для животного
 */
public class AddCommandAnimal extends Command{

    public AddCommandAnimal(ConsoleView consoleView) {
        super("Добавить команду животному", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addCommandAnimal();
    }
}