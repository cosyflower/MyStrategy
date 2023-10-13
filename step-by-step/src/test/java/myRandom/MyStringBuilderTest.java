package myRandom;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStringBuilderTest {
    @Test
    void Using_StringBuilder_Join() {
        String[] tempStrings = {"Samsung", "Apple"};
        String joinedString = String.join(".", tempStrings);
        Assertions.assertThat(joinedString).isEqualTo("Samsung.Apple");
    }
}
