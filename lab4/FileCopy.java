// задание 2, вариант 2
package JavaLabs.lab4;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {

                System.out.println(System.getProperty("user.dir"));

        String sourceFile = "/home/evg/Projects/Java/lab4/input.txt";
        String destinationFile = "/home/evg/Projects/Java/lab4/output.txt";

        try (
                FileReader reader = new FileReader(sourceFile);
                FileWriter writer = new FileWriter(destinationFile)
        ) {

            int character;

            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

            System.out.println("Файл успешно скопирован.");

        } catch (FileNotFoundException e) {

            System.out.println("Ошибка: Исходный файл не найден.");

        } catch (IOException e) {

            System.out.println("Ошибка при чтении или записи файла:");
            System.out.println(e.getMessage());

        }
    }
}