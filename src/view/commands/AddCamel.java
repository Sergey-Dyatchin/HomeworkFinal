package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления верблюда
 */
public class AddCamel extends Command{

    public AddCamel(ConsoleView consoleView) {
        super("Добавить верблюда", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addCamel();
    }
}
