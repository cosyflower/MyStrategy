package beforeCT.controllertest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.Arrays;

public class SimpleAssertion {
    // Mockito 연결되어 있는 것까지 확ㅇ니
    // AssertJ, JUnit 모두 활용이 가능한 모습까지 확인이 가능했다
    private static Duration SIMPLE_TEST_TIME = Duration.ofSeconds(1L);

    public static void assertRandomTest(Executable executable) {
        Assertions.assertTimeoutPreemptively(SIMPLE_TEST_TIME, executable);
    }

    public static void pickRandomNumber(Executable executable, Integer value, Integer... values) {
        // Verification 상황을 먼저 명시해야 한다 - ArgumentMatcher를 적용하는 구간이라고 생각할 수 있겠다
        assertRandomNumber(
                () -> {
                    MockRandom.pickRandomNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
                },
                executable, value, values
        );
    }

    public static <T> void assertRandomNumber(
            MockedStatic.Verification verification,
            final Executable executable,
            final T value,
            final T... values) {
        assertRandomTest(() -> {
            // MockRandom 내부에 위치하는 public static 메서드 관련 객체를 형성한다고 할 수 있다
            MockedStatic<MockRandom> randomMocked = Mockito.mockStatic(MockRandom.class);
            try {
                randomMocked.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
