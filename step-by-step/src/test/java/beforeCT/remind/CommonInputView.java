package beforeCT.remind;

import java.util.Map;

public interface CommonInputView<K> {
    K input(Map<String, Object> model);
}
