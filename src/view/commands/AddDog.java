package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления собаки
 */
public class AddDog extends Command{

    public AddDog(ConsoleView consoleView) {
        super("Добавить собаку", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addDog();
    }
}
