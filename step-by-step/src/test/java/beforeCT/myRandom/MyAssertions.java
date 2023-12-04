package beforeCT.myRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class MyAssertions {
    private static final Duration SIMPLE_TIME_OUT = Duration.ofSeconds(1L);
    private static final Duration RANDOM_TIME_OUT = Duration.ofSeconds(1L);

    public static void assertMySimpleTest(Executable executable) {
        Assertions.assertTimeoutPreemptively(SIMPLE_TIME_OUT, executable);
    }

    public static void checkMyRandomNumber(Executable executable, Integer value, Integer... values) {
        // executable - main() 에서 돌아가는 코드, 인자 전달할 애들 다 전달하고
        // 결과까지 확인해주면 되겠다. assertThat(output()).contains("확인하고자 하는 메세지")
        assertMyRandom(
                () -> {
                    MyRandom.pickNumberInList(ArgumentMatchers.anyList());
                },
                executable,
                value, values
        );
    }

    public static void checkMyRandomNumbersInRange(Executable executable, List<Integer> numberList
            , List<Integer>... numberLists) {
        assertMyRandom(
                () -> {
                    MyRandom.pickUniqueNumbersInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(),
                            ArgumentMatchers.anyInt());
                }, executable, numberList, numberLists
        );
    }

    public static <T> void myShuffleTest(Executable executable, T number, T... numbers) {
        assertMyRandom(
                () -> MyRandom.shuffle(ArgumentMatchers.anyList()),
                executable, number, numbers
        );
    }

    public static <T> void assertMyRandom(MockedStatic.Verification verification, Executable executable, T number,
                                          T... numbers) {
        MockedStatic<MyRandom> randomsMockedStatic = Mockito.mockStatic(MyRandom.class);
        try {
            randomsMockedStatic.when(verification).thenReturn(number, Arrays.stream(numbers).toArray());
            executable.execute();
        } catch (Throwable e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

}
