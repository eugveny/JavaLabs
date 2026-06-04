//task 1
package Java.lab5;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The tallest mountain in the European Union is Mont Blanc: its official recorded height is 4.805 meters or 15.766 feet.";
        String regex = "\\d+(\\.\\d+)?"; // любая цифра, можно доброе число

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Found numbers:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }    
}
