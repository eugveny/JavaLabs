// task 3
package Java.lab4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomExceptionLab {

    public static void logError(String msg) {
        try (FileWriter writer = new FileWriter("/home/evg/Projects/Java/l4/error_log.txt", true)) {
            writer.write("ОШИБКА: " + msg + "\n");
        } catch (IOException e) {
            System.err.println("Запись в лог невозможна");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");

        try {
            String input = scanner.nextLine();

            if (!input.matches("-?\\d+")) {
                throw new CustomInputMismatchException("Введено не целое число: " + input);
            }

            int value = Integer.parseInt(input);
            System.out.println("Число: " + value);

        } catch (CustomInputMismatchException e) {
            System.err.println(e.getMessage());
            logError(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Программа завершена.");
        }
    }
}