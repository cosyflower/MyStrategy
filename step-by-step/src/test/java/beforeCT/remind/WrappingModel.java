package beforeCT.remind;

import java.util.HashMap;
import java.util.Map;

public class WrappingModel<T> {
    // 가장 최근의 값만 가지게 된다 (HashMap 특성 상)
    // Map<String, List<>> 형태로도 유지할 수 있다 - List 내부 조회가 가능하다
    private final Map<String, T> model = new HashMap<>();

    public boolean hasValue(String keyMapper) {
        return model.containsKey(keyMapper);
    }

    public T getValue(String keyMapper) {
        return model.get(keyMapper);
    }
}
