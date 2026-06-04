// задание 4
package JavaLabs.lab5;
import java.util.regex.*;

public class IPValidator {
    public static void main(String[] args) {
        String ip = "127.255.255.19";
        String number = "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])"; // дозволенные рамки
        String regex = "^" + number + "\\." + number + "\\." + number + "\\." + number + "$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()) {
            System.out.println("Correct IP");
        } else {
            System.out.println("Incorrect IP");
        }
    }
}
