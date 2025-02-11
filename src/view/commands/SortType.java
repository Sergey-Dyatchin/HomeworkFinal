package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод сортировки реестра по виду животного
 */
public class SortType extends Command{
    public SortType(ConsoleView consoleView) {
        super("Сортировать по виду животных", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().sortType();
    }
}
