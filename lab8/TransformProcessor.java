// обработчик
package JavaLabs.lab8;
import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<Integer> transform(List<Integer> data) {
        return data.stream() // число по stream api
                .map(number -> number * 2)
                .collect(Collectors.toList());
    }
}