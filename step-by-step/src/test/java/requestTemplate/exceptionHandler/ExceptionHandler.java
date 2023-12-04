package requestTemplate.exceptionHandler;

import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T from(Supplier<T> suppler) {
        try {
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return from(suppler);
        }
    }
}
