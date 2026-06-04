//task 3
package Java.lab5;
import java.util.regex.*;

public class CaseHighlighter {
    public static void main(String[] args) {
        String text = "helloMyZen Isalwaysbehappy";
        String regex = "([a-z])([A-Z])"; // маленькие и большие буквы в грпупах соответственно

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("$1A$2!");

        System.out.println(result);

        // prikol.exe
        String upper = result.replaceAll("[^A-Z]", "");
        upper += "NG";
        System.out.println(upper);
    }
}
