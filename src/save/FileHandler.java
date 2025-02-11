package save;

import java.io.*;

/**
 * Реализация сохранения и загрузки
 */
public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable, String filePatch) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePatch))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            System.out.println("Error save!");
            e.printStackTrace();
        }
    }

    @Override
    public Object load(String filePatch) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePatch))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Error load!");
            e.printStackTrace();
            return null;
        }
    }
}