package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления лошади
 */
public class AddHorse extends Command{

    public AddHorse(ConsoleView consoleView) {
        super("Добавить лошадь", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addHorse();
    }
}
