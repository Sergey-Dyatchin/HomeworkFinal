package view.commands;

import view.ConsoleView;
/**
 * Вызывает метод сохранения текущего реестр в файл, старый файл сохранения будет перезаписан
 */
public class Save extends Command {

    public Save(ConsoleView consoleView) {
        super("Сохранить реестр питомника", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().savingRegistry();
    }
}
