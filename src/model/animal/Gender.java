package model.animal;

/**
 * Перечисление полов
 */
public enum Gender {
    MALE("Мальчик"),
    FEMALE("Девочка");

    private final String title;

    Gender(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
