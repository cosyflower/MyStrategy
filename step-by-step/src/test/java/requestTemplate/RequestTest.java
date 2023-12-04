package requestTemplate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestTest {
    @Test
    void flow() {
        RequestWithNewClass inputValue = new RequestWithNewClass("3");
        SpecificClass specificClass = inputValue.toSpecificClass();
        Assertions.assertThat(specificClass.getInputNumber()).isEqualTo(3);
    }
}
