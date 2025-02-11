package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления осла
 */
public class AddDonkey extends Command{

    public AddDonkey(ConsoleView consoleView) {
        super("Добавить осла", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addDonkey();
    }
}
