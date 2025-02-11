package save;

import java.io.Serializable;

/**
 * Интерфейс сохранения и загрузки реестра животных
 */
public interface Writable {
    /**
     * Сохранение в файл
     *
     * @param serializable принимает сериализуемый объект
     * @param filePatch путь к файлу
     */
    void save(Serializable serializable, String filePatch);

    /**
     * Загрузка реестра из файла
     *
     * @param filePatch путь к файлу
     */
    Object load(String filePatch);
}
