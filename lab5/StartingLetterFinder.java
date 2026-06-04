// задание 5
package JavaLabs.lab5;
import java.util.regex.*;

public class StartingLetterFinder {
    public static void main(String [] args) {
        String text = "I love IT! But sometimes programming can be quite difficult to understand logically. Is it not interesting?";
        char letter = 'I';
        String regex = "\\b" + letter + "\\w*"; // граница слова ... оставшиеся символы

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Words found:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
