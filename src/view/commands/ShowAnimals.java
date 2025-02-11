package view.commands;

import view.ConsoleView;
/**
 * Вызывает метод вывода в консоль всех животных и
 * запускает меню сортировки
 */
public class ShowAnimals extends Command{
    public ShowAnimals(ConsoleView consoleView) {
        super("Показать животных ->", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().showAnimals();
    }
}
