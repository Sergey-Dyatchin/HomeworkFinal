package view;

import Service.RegisterService;
import model.animal.Gender;
import view.menu.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Консольный интерфейс пользователя
 */
public class ConsoleView implements View {

    // region Поля
    /**
     * Сканер для обратной связи от пользователя
     */
    private final Scanner scanner;

    /**
     * Сервис для взаимодействия с реестром
     */
    private final RegisterService registerService;

    /**
     * Список Boolean для работы подменю меню
     */
    private final List<Boolean> workMenu;

    /**
     * Главное меню
     */
    private final Menu startMenu;

    /**
     * Путь к файлу сохранения
     */
    private final String filePatch;
    // endregion

    /**
     * Конструктор
     */
    public ConsoleView() {
        scanner = new Scanner(System.in);
        workMenu = new ArrayList<>();
        registerService = new RegisterService();
        startMenu = new StartMenu(this);
        filePatch = "src/save/register";
    }

    @Override
    public void start() {
        System.out.println("Запускаем программу");
        launchingMenu(startMenu);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    // region Внутренние методы

    /**
     * Запускает меню,
     * выполняет команды из меню в соответствии с выбором пользователя
     *
     * @param menu Menu
     */
    private void launchingMenu(Menu menu) {
        workMenu.add(true);
        while (workMenu.getLast()) {
            System.out.println(menu.showMenu());
            int choice = chekingCoice(menu.getCommands().size() - 1);
            if (choice >= 0) {
                menu.execute(choice);
            }
        }
        workMenu.removeLast();
    }

    /**
     * Проверяет допустимость введенного пользователем число ли это и не превышает ли максимум
     * если значение не допустимо печатает ошибку
     *
     * @param max ограничение включительно
     * @return возвращает корректное число int или -1 если значение не допустимо
     */
    private int chekingCoice(int max) {
        String choiceStr = scanner.nextLine();
        int choice;
        try {
            choice = Integer.parseInt(choiceStr);
            if (choice <= max && choice >= 0) {
                return choice;
            }
            printError(max);
        } catch (NumberFormatException e) {
            printError(max);
        }
        return -1;
    }

    /**
     * Печатает сообщение пользователю о некорректности данных и корректном диапазоне
     *
     * @param max ограничение включительно
     */
    private void printError(int max) {
        System.out.printf("Вы ввели не корректные данные \nВведите число от %d до %d\n", 0, max);
    }

    /**
     * Запрашивает у пользователя имя животного в цикле
     * пока не будет получено корректное значение
     * не допускает пустого ввода
     *
     * @return String имя животного (не пустое)
     */
    private String enteringName() {
        String name;
        boolean repeatQuestion;

        do {
            System.out.println("Введите имя животного: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                repeatQuestion = true;
                System.out.println("Вы ничего не ввели");
            } else {
                repeatQuestion = false;
            }
        } while (repeatQuestion);
        return name;
    }

    /**
     * Запрашивает у пользователя пол животного в цикле
     * пока не будет получено корректное значение
     * требует ввода "М" или "Ж" без учета регистра в русской раскладке
     *
     * @return Gender в зависимости от ввода пользователя
     */
    private Gender enteringGender() {
        String genderStr;
        System.out.println("Укажите пол питомца: М или Ж");
        do {
            genderStr = scanner.nextLine().toLowerCase();
            switch (genderStr) {
                case ("м"):
                    return Gender.MALE;
                case ("ж"):
                    return Gender.FEMALE;
                default:
                    System.out.println("Укажите пол: М или Ж (Русская раскладка)");
                    break;
            }
        } while (true);
    }

    /**
     * Запрашивает у пользователя дату рождения животного в цикле
     * пока не будет получено корректное значение
     * Вначале год (1900 - 2100), потом месяц потом день
     * @return LocalDate
     */
    private LocalDate enteringData() {
        StringBuilder dateStr = new StringBuilder();
        LocalDate date = null;
        String temp;
        int intTemp;
        boolean repeatQuestion;

        System.out.println("Введите год рождения питомца");
        do {
            temp = scanner.nextLine();
            try {
                intTemp = Integer.parseInt(temp);
                if (intTemp >= 1900 && intTemp <= 2100) {
                    dateStr.append(temp);
                    repeatQuestion = false;
                } else {
                    System.out.println("укажите год от 1900 до 2100");
                    repeatQuestion = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("укажите год от 1900 до 2100");
                repeatQuestion = true;
            }
        } while (repeatQuestion);

        dateStr.append("-");
        System.out.println("Введите месяц");

        do {
            temp = scanner.nextLine();
            try {
                intTemp = Integer.parseInt(temp);
                if (intTemp < 13 && intTemp > 0) {
                    if (temp.length() < 2) {
                        dateStr.append("0");
                    }
                    dateStr.append(temp);
                    repeatQuestion = false;
                } else {
                    System.out.println("укажите месяц от 1 до 12");
                    repeatQuestion = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("укажите месяц от 1 до 12");
                repeatQuestion = true;
            }
        }
        while (repeatQuestion);

        dateStr.append("-");
        System.out.println("Введите число");

        do {
            temp = scanner.nextLine();
            try {
                intTemp = Integer.parseInt(temp);
                if (intTemp < 32 && intTemp > 0) {
                    if (temp.length() < 2) {
                        dateStr.append("0");
                    }
                    dateStr.append(temp);
                    date = LocalDate.parse(dateStr.toString());
                    repeatQuestion = false;
                } else {
                    System.out.println("укажите число от 1 до 31");
                    repeatQuestion = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("укажите число от 1 до 31");
                repeatQuestion = true;
            } catch (DateTimeParseException e) {
                System.out.println("Такого числа нет в этом месяце");
                repeatQuestion = true;
                dateStr.deleteCharAt(dateStr.length() - 1).deleteCharAt(dateStr.length() - 1);
            }
        }
        while (repeatQuestion);

        return date;
    }

    /**
     * Печатает пользователю команды из реестра которые не знает выбранное животное, и еще не выбрал пользователь
     * добавляет выбранные команды в список,
     * повторяет операция пока пользователь не прервет добавление
     * @param newAnimal true для вызова метода при создании животного и false при добавлении команд животному из реестра
     * @return List<String> список команд которых ранее животное не знало
     */
    private List<String> selectCommand(Boolean newAnimal) {
        List<String> selectedCommands = new ArrayList<>();
        if (!newAnimal) {
            selectedCommands.addAll(registerService.getCurrentAnimal().getCommands());
        }
        List<String> availableCommands = new ArrayList<>();
        for (String command : registerService.getCommands()) {
            if (!selectedCommands.contains(command)) {
                availableCommands.add(command);
            }
        }
        boolean repeatQuestion = true;
        String temp;
        int intTemp;
        do {
            System.out.println("Команды уже добавленные:");
            for (int i = 0; i < selectedCommands.size(); i++) {
                System.out.println((i + 1) + ". " + selectedCommands.get(i));
            }

            System.out.println("Выберите команду которую добавить питомцу:");
            for (int i = 0; i < availableCommands.size(); i++) {
                System.out.println((i + 1) + ". " + availableCommands.get(i));
            }
            System.out.println((availableCommands.size() + 1) + ". Закончить добавление команд");

            temp = scanner.nextLine();
            try {
                intTemp = Integer.parseInt(temp);
                if (intTemp == availableCommands.size() + 1) {
                    repeatQuestion = false;
                } else if (intTemp < availableCommands.size() + 1 && intTemp > 0) {
                    selectedCommands.add(availableCommands.get(intTemp - 1));
                    availableCommands.remove(intTemp - 1);
                } else {
                    System.out.println("укажите число от 1 до " + (availableCommands.size() + 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("укажите число от 1 до " + (availableCommands.size() + 1));
            }
        } while (repeatQuestion);

        return selectedCommands;
    }

    /**
     * Запрашивает в цикле у пользователя грузоподъемность вьючного животного
     * пока не будет введено число
     * @return int грузоподъемность
     */
    private int enteringLoadCapacity() {
        String temp;
        int loadcapacity;
        System.out.println("Введите грузоподъемность:");
        while (true) {
            temp = scanner.nextLine();
            try {
                loadcapacity = Integer.parseInt(temp);
                return loadcapacity;
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число");
            }
        }
    }

    /**
     * Запрашивает у пользователя любит ли питомец людей в цикле
     * ожидает ответ "да" или "нет" без учета регистра на русской раскладке
     * @return boolean true или false в зависимости от ввода
     */
    private boolean enteringLovesPeople() {
        String temp;
        System.out.println("Питомец любит людей? да или нет");
        do {
            temp = scanner.nextLine().toLowerCase();
            switch (temp) {
                case ("да"):
                    return true;
                case ("нет"):
                    return false;
                default:
                    System.out.println("Укажите да или нет (Русская раскладка)");
                    break;
            }
        } while (true);
    }

    /**
     * Сортирует реестр по id
     * отображает реестр пользователю,
     * запоминает в currentAnimal выбранное животное по id
     * операция выполняется в цикле до ввода пользователем корректных данных
     */
    private void selectedAnimal() {
        String temp;
        int intTemp;
        boolean repeatQuestion = true;
        registerService.sortId();
        System.out.println(registerService.printAnimals());
        System.out.println("Введите Id животного");
        do {
            temp = scanner.nextLine();
            try {
                intTemp = Integer.parseInt(temp);
                if (intTemp <= registerService.getCountAnimals() && intTemp > 0) {
                    registerService.selectedCurrentAnimal(intTemp);
                    repeatQuestion = false;
                } else {
                    System.out.println("укажите число от 1 до " + registerService.getCountAnimals());
                }
            } catch (NumberFormatException e) {
                System.out.println("укажите число от 1 до " + registerService.getCountAnimals());
            }
        } while (repeatQuestion);
    }
    // endregion

    // region Команды

    /**
     * Команда Справка
     * печатает справку
     */
    public void callingHelp() {
        System.out.println("""
                ******************* Справка ******************
                *               Структура меню               *
                * 0. - Вызывает эту справку *
                * 1. - Сохраняет реестр питомника из файла по адресу: src/save/register *
                * 2. - Загружает реестр питомника в файл по адресу: src/save/register *
                * 3. - Открывает меню  выбора животного для добавления *
                *     0. - Вызывает эту справку *
                *     1. - Добавляет кота спрашивая пользователя *
                *     2. - Добавляет собаку спрашивая пользователя *
                *     3. - Добавляет хомяка спрашивая пользователя *
                *     4. - Добавляет лошадь спрашивая пользователя *
                *     5. - Добавляет осла спрашивая пользователя *
                *     6. - Добавляет верблюда спрашивая пользователя *
                *     7. - Выходит в предыдущее меню *
                * 4. - Отображает текущих животных и вызывает меню выбора сортировок *
                *     0. - Вызывает эту справку *
                *     1. - Сортирует реестр по Id *
                *     2. - Сортирует реестр по дате рождения *
                *     3. - Сортирует реестр по дате поступления *
                *     4. - Сортирует реестр по виду животных *
                *     5. - Выводит количество животных в питомнике *
                *     6. - Выходит в предыдущее меню *
                * 5. - Вызывает меню выбора печати дерева *
                *     0. - Вызывает эту справку *
                *     1. - Добавление новой команды в список доступных команд *
                *     2. - Добавление питомцу команды из списка доступных *
                *     3. - Выходит в предыдущее меню *
                * 6. - Выходит из программы *
                """
        );
    }

    /**
     * Команда выход
     * устанавливает последний элемент workMenu в false
     */
    public void goOut() {
        workMenu.set(workMenu.size() - 1, false);
    }

    /**
     * Команда загрузить реестр
     * загружает реестр из файла
     */
    public void loadingRegistry() {
        registerService.loadingRegistry(filePatch);
    }

    /**
     * Команда сохранить реестр
     * сохраняет реестр в файл
     */
    public void savingRegistry() {
        registerService.savingRegistry(filePatch);
    }

    /**
     * Команда добавить животное
     * создает и запускает меню добавления животного
     */
    public void addAnimal() {
        Menu addAnimalMenu = new AddAnimalMenu(this);
        launchingMenu(addAnimalMenu);
    }

    /**
     * Команда добавления верблюда
     * добавляет верблюда в реестр
     * запрашивая его параметры у пользователя
     */
    public void addCamel() {
        printAnswer("Добавлен: \n" + registerService.addCamel(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLoadCapacity()));
    }

    /**
     * Команда добавления кошки
     * добавляет кошку в реестр
     * запрашивая ее параметры у пользователя
     */
    public void addCat() {
        printAnswer("Добавлен: \n" + registerService.addCat(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLovesPeople()));
    }

    /**
     * Команда добавления собаки
     * добавляет собаку в реестр
     * запрашивая ее параметры у пользователя
     */
    public void addDog() {
        printAnswer("Добавлен: \n" + registerService.addDog(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLovesPeople()));
    }

    /**
     * Команда добавления осла
     * добавляет осла в реестр
     * запрашивая его параметры у пользователя
     */
    public void addDonkey() {
        printAnswer("Добавлен: \n" + registerService.addDonkey(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLoadCapacity()));
    }

    /**
     * Команда добавления хомяка
     * добавляет хомяка в реестр
     * запрашивая его параметры у пользователя
     */
    public void addHamster() {
        printAnswer("Добавлен: \n" + registerService.addHamster(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLovesPeople()));
    }

    /**
     * Команда добавления лошади
     * добавляет лошадь в реестр
     * запрашивая ее параметры у пользователя
     */
    public void addHorse() {
        printAnswer("Добавлен: \n" + registerService.addHorse(enteringName(), enteringGender(), enteringData(),
                selectCommand(true), enteringLoadCapacity()));
    }

    /**
     * Команда показать животных
     * печатает животных из реестра
     * создает и отображает меню сортировки
     */
    public void showAnimals() {
        Menu showAnimalsMenu = new ShowAnimalsMenu(this);
        System.out.println(registerService.printAnimals());
        launchingMenu(showAnimalsMenu);
    }

    /**
     * Команда сортировать по дате рождения
     * сортирует реестр по дате рождения
     * печатает реестр животных
     */
    public void sortBirthDate() {
        registerService.sortBirthDate();
        System.out.println("Сортировка по дате рождения");
        System.out.println(registerService.printAnimals());
    }

    /**
     * Команда сортировать по id
     * сортирует реестр по id
     * печатает реестр животных
     */
    public void sortId() {
        registerService.sortId();
        System.out.println("Сортировка по Id");
        System.out.println(registerService.printAnimals());
    }

    /**
     * Команда сортировать по дате поступления
     * сортирует реестр по дате поступления
     * печатает реестр животных
     */
    public void sortReceptionDate() {
        registerService.sortReceptionDate();
        System.out.println("Сортировка по дате поступления");
        System.out.println(registerService.printAnimals());
    }

    /**
     * Команда сортировать по виду животных
     * сортирует реестр по виду животных
     * печатает реестр животных
     */
    public void sortType() {
        registerService.sortType();
        System.out.println("Сортировка по виду животного");
        System.out.println(registerService.printAnimals());
    }
    /**
     * Команда количество животных
     * печатает сколько животных в реестре
     */
    public void getCountAnimals() {
        System.out.println("Текущие количество животных в питомнике: " + registerService.getCountAnimals());
    }

    /**
     * Команда добавить команду
     * создает и печатает меню добавление команды
     */
    public void addCommand() {
        Menu addCommandMenu = new AddCommandMenu(this);
        launchingMenu(addCommandMenu);
    }

    /**
     * Команда добавить команду животному
     * запускает метод выбора животного из реестра
     * и метод добавления выбранному животному команд
     */
    public void addCommandAnimal() {
        selectedAnimal();
        System.out.println("Выбрано: \n" + registerService.getCurrentAnimal());
        registerService.getCurrentAnimal().addCommands(selectCommand(false));
    }

    /**
     * Команда добавления новой команды в реестр
     * запрашивает в цикле у пользователя название новой команды
     * не позволяет ввести пусто поле
     * добавляет полученное корректное значение String в список команд реестра
     */
    public void addCommandRegister() {
        String command;
        boolean repeatQuestion;

        do {
            System.out.println("Введите название команды: ");
            command = scanner.nextLine();
            if (command.isEmpty()) {
                repeatQuestion = true;
                System.out.println("Вы ничего не ввели");
            } else {
                repeatQuestion = false;
            }
        } while (repeatQuestion);
        printAnswer(registerService.addCommandRegister(command));
    }
    // endregion
}
