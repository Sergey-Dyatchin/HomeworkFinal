package view;

/**
 * Интерфейс для пользовательского интерфейса
 */
public interface View {
    /**
     * Запускает пользовательский интерфейс
     */
    void start();

    /**
     * Для передачи ответа из программы в интерфейс
     * @param answer String
     */
    void printAnswer(String answer);
}

