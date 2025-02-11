package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод сортировки реестра по id
 */
public class SortId extends Command{
    public SortId(ConsoleView consoleView) {
        super("Сортировать по Id", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().sortId();
    }
}
