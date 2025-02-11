package model.registry;

import model.animal.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Реестр животных
 */
public class Registry implements Serializable {
    /**
     * Счетчик для генерации Id у животных
     */
    private int count;

    /**
     * Список для хранения животных
     */
    private final ArrayList<Animal> animalList;

    /**
     * Список для хранения всех доступных команд
     * команды из этого списка могут знать животные
     */
    private final ArrayList<String> existingCommandList;

    /**
     * Конструктор добавляет стандартные команды в список
     */
    public Registry() {
        animalList = new ArrayList<>();
        existingCommandList = new ArrayList<>();

        existingCommandList.add("Сидеть");
        existingCommandList.add("Лежать");
        existingCommandList.add("Прыгать");
        existingCommandList.add("Стоять");
        existingCommandList.add("Идти");
        existingCommandList.add("Бежать");
        existingCommandList.add("Голос");
    }

    /**
     * Добавление животного в реестр
     * и увеличение счетчика на 1
     *
     * @param animal добавляемое животное
     */
    public void addAnimal(Animal animal) {
        animalList.add(animal);
        animal.setId(++count);
    }

    /**
     * Добавление команды в реестр известных команд
     *
     * @param command String
     * @return String сообщение о результате добавления
     */
    public String addNewCommand(String command) {
        existingCommandList.add(command);
        return existingCommandList.contains(command) ? "Добавлена команда: " + command : "Ошибка добавления команды";
    }

    // region Сеттеры и Геттеры
    public ArrayList<String> getExistingCommandList() {
        return existingCommandList;
    }

    public List<Animal> getAllAnimals() {
        return animalList;
    }

    public int getCount() {
        return count;
    }
    // endregion

    // region сортировки

    /**
     * Сортировка животных по дню рождения
     */
    public void sortBirthDate() {
        animalList.sort(new AnimalComparatorBirthDate<>());
    }

    /**
     * Сортировка животных id
     */
    public void sortId() {
        animalList.sort(new AnimalComparatorId<>());
    }

    /**
     * Сортировка животных по дню поступления
     */
    public void sortReceptionDate() {
        animalList.sort(new AnimalComparatorReceptionDate<>());
    }

    /**
     * Сортировка животных по виду
     */
    public void sortType() {
        animalList.sort(new AnimalComparatorType<>());
    }
    // endregion
}

