// аннотация
package JavaLabs.lab8;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

// собственная аннотация
public @interface DataProcessor {
}