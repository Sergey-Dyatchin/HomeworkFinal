package view.commands;

import view.ConsoleView;

/**
 * Вызывает меню добавления команды
 */
public class AddCommand extends Command{

    public AddCommand(ConsoleView consoleView) {
        super("Добавить команду ->", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addCommand();
    }
}