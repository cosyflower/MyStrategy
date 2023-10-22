package review;

import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

public class PersonTest {
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

}
