package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления хомяка
 */
public class AddHamster extends Command{

    public AddHamster(ConsoleView consoleView) {
        super("Добавить хомяка", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addHamster();
    }
}
