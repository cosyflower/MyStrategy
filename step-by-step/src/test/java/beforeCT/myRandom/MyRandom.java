package beforeCT.myRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MyRandom {
    private static final Random random = ThreadLocalRandom.current();

    public static int pickNumberInList(List<Integer> numbers) {
        validateNumbers(numbers);
        return numbers.get(pickRandomNumberInRange(0, numbers.size() - 1));
    }

    public static int pickRandomNumberInRange(int startInclusive, int endInclusive) {
        validateRange(startInclusive, endInclusive);
        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }

    public static List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        validateCount(startInclusive, endInclusive, count);
        validateRange(startInclusive, endInclusive);
        List<Integer> pickedList = new ArrayList<>();

        IntStream.range(startInclusive, endInclusive + 1)
                .forEach((numberInRange) -> pickedList.add(numberInRange));

        Collections.shuffle(pickedList);
        return pickedList.subList(0, count);
    }

    private static void validateCount(int startInclusive, int endInclusive, int count) {
        if ((endInclusive - startInclusive + 1) < count) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty numbers");
        }
    }

    private static void validateRange(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("Wrong Range!");
        }

        if (startInclusive > Integer.MAX_VALUE || endInclusive > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Input Range has overloaded");
        }
    }

    public static <T> List<T> shuffle(List<T> numbers) {
        // generic 명시할 때는 반환형 앞에 작성하는 것으로!
        List<T> newList = new ArrayList<>(numbers);
        Collections.shuffle(newList);
        return newList;
    }

    public static void new_function(List<Integer> notList) {

    }

}
