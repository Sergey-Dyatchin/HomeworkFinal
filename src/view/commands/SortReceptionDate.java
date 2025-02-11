package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод сортировки реестра по дню поступления
 */
public class SortReceptionDate extends Command{
    public SortReceptionDate(ConsoleView consoleView) {
        super("Сортировать по дате поступления", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().sortReceptionDate();
    }
}
