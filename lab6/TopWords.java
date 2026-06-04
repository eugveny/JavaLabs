//task 1
package Java.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {

    public static void main(String[] args) {

        String filePath = "/home/evg/Projects/Java/lab6/text.txt";

        File file = new File(filePath);

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        while (scanner.hasNext()) {

            String word = scanner.next();

            word = word.toLowerCase();
            word = word.replaceAll("[^а-яa-z0-9]", "");

            if (word.isEmpty()) {
                continue;
            }

            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        Collections.sort(
                list,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
        );

        System.out.println("Топ-10 слов:\n");

        int limit = Math.min(10, list.size());

        for (int i = 0; i < limit; i++) {

            Map.Entry<String, Integer> entry = list.get(i);

            System.out.println(
                    (i + 1) + ". " +
                    entry.getKey() +
                    " -> " +
                    entry.getValue()
            );
        }
    }
}