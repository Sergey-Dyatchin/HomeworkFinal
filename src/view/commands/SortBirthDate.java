package view.commands;

import view.ConsoleView;

/**
 * Вызывает метод сортировки реестра по дню рождения
 */
public class SortBirthDate extends Command{
    public SortBirthDate(ConsoleView consoleView) {
        super("Сортировать по дате рождения", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().sortBirthDate();
    }
}
