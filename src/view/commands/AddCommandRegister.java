package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод добавления команд в реестр
 */
public class AddCommandRegister extends Command{

    public AddCommandRegister(ConsoleView consoleView) {
        super("Добавить команду в реестр", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addCommandRegister();
    }
}
