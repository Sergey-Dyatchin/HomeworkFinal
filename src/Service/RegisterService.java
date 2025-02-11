package Service;

import model.animal.Animal;
import model.animal.Gender;
import model.animal.pack_animals.*;
import model.animal.pets.*;
import model.registry.Registry;
import save.FileHandler;
import save.Writable;

import java.time.LocalDate;
import java.util.List;

public class RegisterService {

    /**
     * Реестр животных
     */
    private Registry registry;

    /**
     * Выбранное животное
     * промежуточная сущность для передачи в другие методы
     */
    private Animal currentAnimal;

    /**
     * Конструктор
     */
    public RegisterService() {
        registry = new Registry();
    }

    /**
     * Загрузка реестра из файла
     *
     * @param filePatch путь к файлу
     */
    public void loadingRegistry(String filePatch) {
        Writable writable = new FileHandler();
        this.registry = (Registry) writable.load(filePatch);
    }

    /**
     * Сохранение реестра в файл
     *
     * @param filePatch путь к файлу
     */
    public void savingRegistry(String filePatch) {
        Writable writable = new FileHandler();
        writable.save(this.registry, filePatch);
    }

    // region Добавления животных

    /**
     * Добавление кошки
     *
     * @return Cat
     */
    public Animal addCat(String name, Gender gender, LocalDate birthDate, List<String> listCommands,
                         boolean lovesPeople) {
        currentAnimal = new Cat(name, gender, birthDate, listCommands, lovesPeople);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }

    /**
     * Добавление собаки
     *
     * @return Dog
     */
    public Animal addDog(String name, Gender gender, LocalDate birthDate,
                         List<String> listCommands, boolean lovesPeople) {
        currentAnimal = new Dog(name, gender, birthDate, listCommands, lovesPeople);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }

    /**
     * Добавление хомяка
     *
     * @return Hamster
     */
    public Animal addHamster(String name, Gender gender, LocalDate birthDate,
                             List<String> listCommands, boolean lovesPeople) {
        currentAnimal = new Hamster(name, gender, birthDate, listCommands, lovesPeople);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }

    /**
     * Добавление осла
     *
     * @return Donkey
     */
    public Animal addDonkey(String name, Gender gender, LocalDate birthDate,
                            List<String> listCommands, int loadCapacity) {
        currentAnimal = new Donkey(name, gender, birthDate, listCommands, loadCapacity);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }

    /**
     * Добавление лошади
     *
     * @return Horse
     */
    public Animal addHorse(String name, Gender gender, LocalDate birthDate,
                           List<String> listCommands, int loadCapacity) {
        currentAnimal = new Horse(name, gender, birthDate, listCommands, loadCapacity);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }

    /**
     * Добавление верблюда
     *
     * @return Camel
     */
    public Animal addCamel(String name, Gender gender, LocalDate birthDate,
                           List<String> listCommands, int loadCapacity) {
        currentAnimal = new Camel(name, gender, birthDate, listCommands, loadCapacity);
        registry.addAnimal(currentAnimal);
        return currentAnimal;
    }
    // endregion

    // region Сортировок реестра
    public void sortBirthDate() {
        registry.sortBirthDate();
    }

    public void sortId() {
        registry.sortId();
    }

    public void sortReceptionDate() {
        registry.sortReceptionDate();
    }

    public void sortType() {
        registry.sortType();
    }
    // endregion

    /**
     * Получение списка всех доступных команд из реестра
     *
     * @return List<String> список команд
     */
    public List<String> getCommands() {
        return registry.getExistingCommandList();
    }

    /**
     * Подготовка к печати списка животных
     * создает String в котором построчно печатаются все животные
     *
     * @return String
     */
    public String printAnimals() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Animal animal : registry.getAllAnimals()) {
            stringBuilder.append(animal).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Выдает значение счетчика, которое соответствует количеству животных в реестре
     * @return int
     */
    public int getCountAnimals() {
        return registry.getCount();
    }

    /**
     * Добавляет команду в реестр доступных команд
     * @param command String
     * @return String добавленную команду
     */
    public String addCommandRegister(String command) {
        return registry.addNewCommand(command);
    }


    public Animal getCurrentAnimal() {
        return currentAnimal;
    }

    /**
     * Выбор currentAnimal по id (смещение -1 для подсчета с 0 элемента)
     * метод применяется только отсортированному по id реестру
     */
    public void selectedCurrentAnimal(int id) {
        currentAnimal = registry.getAllAnimals().get(id - 1);
    }
}
