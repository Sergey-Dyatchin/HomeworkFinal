package view.commands;

import view.ConsoleView;
/**
 * Вызывает метод загрузки ранее сохраненного реестра из файла
 */
public class Load extends Command {

    public Load(ConsoleView consoleView) {
        super("Загрузить реестр питомника", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().loadingRegistry();
    }
}
