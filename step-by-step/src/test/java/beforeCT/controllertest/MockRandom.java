package beforeCT.controllertest;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MockRandom {
    public static final Random random = ThreadLocalRandom.current();

    // Test ( 다른 static 함수에서 내가 Verification으로 지정한 함수를 호출했을 때 결과 확인하기 )
    // 실패.. 이상한 결과가 도출되었다 (애초에 호출도 되지 않은 모습이였다)
    public static void callFuncForTest(int start, int end) {
        System.out.println("callFUncForTest() called = ");

        int number = pickRandomNumberInRange(start, end);
        System.out.println("number = " + number);
    }

    public static int pickRandomNumberInRange(int startInclusive, int endInclusive) {
        validateRandomRange(startInclusive, endInclusive);
        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }

    private static void validateRandomRange(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (startInclusive > Integer.MAX_VALUE || endInclusive > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public static void displaySententce(String hello) {
        System.out.println(hello);
    }
}
