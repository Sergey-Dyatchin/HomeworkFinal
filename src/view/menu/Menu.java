package view.menu;

import view.commands.Command;

import java.util.List;

/**
 * Абстрактный класс для создания меню
 */
public abstract class Menu {
    /**
     * Список команд меню
     */
    protected List<Command> commands;
    /**
     * Название меню
     */
    protected String menuName;

    /**
     * Создает StringBuilder и добавляет в него название меню и список команд из передаваемого меню,
     * а также визуальный разделитель из *
     * возвращает результат преобразованный в строку
     *
     * @return String
     */
    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("********************\n");
        stringBuilder.append(menuName);
        stringBuilder.append("\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.append("********************");
        return stringBuilder.toString();
    }

    /**
     * Получает int и выполняет метод execute в команде из массива по этому индексу
     *
     * @param choice
     */
    public void execute(int choice) {
        commands.get(choice).execute();
    }

    public List<Command> getCommands() {
        return commands;
    }
}

