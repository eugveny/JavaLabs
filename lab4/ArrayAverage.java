// задание 1
package JavaLabs.lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"10", "20", "30.5", "abc", "2"};
        double sum = 0;
        int count = 0; 

        try {
            for (int i = 0; i <= arr.length; i++) {
                double num = Double.parseDouble(arr[i]);
                sum += num;
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: Выход за границы массива (индекс не существует).");
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат данных (встретилось не число).");
        } finally {
            if (count > 0) {
                System.out.println("Среднее арифметическое: " + (sum / count));
            } else {
                System.out.println("Не удалось посчитать среднее.");
            }
        }
    }
}
