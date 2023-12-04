package requestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ComposedB {
    LEVEL_1("레벨1"),
    LEVEL_2("레벨2"),
    LEVEL_3("레벨3"),
    LEVEL_4("레벨4"),
    LEVEL_5("레벨5");

    private final String levelName;

    ComposedB(String levelName) {
        this.levelName = levelName;
    }

    private static Map<String, ComposedB> levelMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(ComposedB::getLevelName, Function.identity()))
    );

    public static ComposedB findComposedB(String inputValue) {
        return Optional.ofNullable(levelMap.get(inputValue)).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 이름입니다.")
        );
    }

    public String getLevelName() {
        return levelName;
    }
}
