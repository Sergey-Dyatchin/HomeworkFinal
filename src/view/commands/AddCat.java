package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления кошки
 */
public class AddCat extends Command{

    public AddCat(ConsoleView consoleView) {
        super("Добавить кота", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addCat();
    }
}
