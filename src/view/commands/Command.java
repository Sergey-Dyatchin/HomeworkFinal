package view.commands;

import view.ConsoleView;

/**
 * Абстрактный класс реализации паттерна команда
 */
public abstract class Command {
    /**
     * Название команды (отображается в меню)
     */
    private final String description;

    /**
     * Консольный интерфейс
     */
    private final ConsoleView consoleView;

    /**
     * Конструктор
     */
    public Command(String description, ConsoleView consoleView) {
        this.description = description;
        this.consoleView = consoleView;
    }

    /**
     * Метод выполнения команды
     */
    public abstract void execute();


    public String getDescription() {
        return description;
    }

    protected ConsoleView getConsoleView() {
        return consoleView;
    }

}