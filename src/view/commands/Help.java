package view.commands;

import view.ConsoleView;
/**
 * Вызывает метод отображения справки
 */
public class Help extends Command{


    public Help(ConsoleView consoleView) {
        super("Вызов справки", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().callingHelp();
    }
}
