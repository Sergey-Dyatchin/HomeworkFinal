package view.commands;

import view.ConsoleView;
/**
 * Вызывает выхода из меню, если это главное меню программа завершит работу
 */
public class Exit extends Command {

    public Exit(ConsoleView consoleView) {
        super("Выйти из меню", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().goOut();
    }
}
