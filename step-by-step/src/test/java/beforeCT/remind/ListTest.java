package beforeCT.remind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListTest {
    @Test
    void List_Remove_Return_removed_Value() {
        List<String> list = new ArrayList(Arrays.asList("1", "2", "3"));
        String removedStringValue = list.remove(0);

        Assertions.assertThat(removedStringValue).isEqualTo("1");
    }
}
