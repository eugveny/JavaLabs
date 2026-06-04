//task 2
package Java.lab5;
import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        String password = "Passw0rd1234";
        String regex = "(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$"; // хотя бы одна большая буква, хотя бы одна цифра, разрешённые символы, длина

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Correct passwrod");
        } else {
            System.out.println("Incorrect password");
        }
    }
}