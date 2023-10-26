package remind;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ModelTest extends WrappingModel<String> {
    @Test
    void test_Hash_Map_Characteristic() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("1", "3");

        String s = map.get("1");
        System.out.println(s);
    }

}
