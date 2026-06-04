// обработчик
package JavaLabs.lab8;
import java.util.List;
import java.util.stream.Collectors;

public class FilterProcessor {
    @DataProcessor
    public List<Integer> filter(List<Integer> data) {
        return data.stream() //список по stream api
                .filter(number -> number > 50)
                .collect(Collectors.toList());
    }
}