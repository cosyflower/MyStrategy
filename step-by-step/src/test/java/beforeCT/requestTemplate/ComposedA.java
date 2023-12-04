package beforeCT.requestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ComposedA {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String courseName;
    private static final Map<String, ComposedA> composedAMap = Collections.unmodifiableMap(
            Arrays.stream(values())
                    .collect(Collectors.toMap(ComposedA::getCourseName, Function.identity()))
    );

    public static ComposedA findComposedAByName(String courseName) {
        return Optional.ofNullable(composedAMap.get(courseName)).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 course입니다."));
    }

    ComposedA(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
