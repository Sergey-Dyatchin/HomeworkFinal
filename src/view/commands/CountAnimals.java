package view.commands;

import view.ConsoleView;
/**
 * Вызывает метод отображения количества животных в реестре
 */
public class CountAnimals extends Command{

    public CountAnimals(ConsoleView consoleView) {
        super("Показать количество животных", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().getCountAnimals();
    }
}