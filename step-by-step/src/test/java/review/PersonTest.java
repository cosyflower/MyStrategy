package review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.function.BiPredicate;

public class PersonTest {
    @Test
    void assertSame_Test() {
        Person boy = new Person("sunghun", 24);
        Person girl = new Person("hyerim", 23);

        Assertions.assertSame(boy, girl);
    }

    @Test
    void compare_String_Join_And_StringJoiner() {
        // String.join()
        String[] stringExamples = {"apple", "Samsung"};
        String joinedString = String.join(";", stringExamples);

        // StringJoiner
        StringJoiner stringJoiner = new StringJoiner(";");
        for (String ex : stringExamples) {
            stringJoiner.add(ex);
        }

        String result = stringJoiner.toString();

        org.assertj.core.api.Assertions.assertThat(joinedString).isEqualTo(result);
    }

    @Test
    void check_assertAll_Arguments() {
        Assertions.assertAll();

    }


}
