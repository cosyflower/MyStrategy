package mvcbaseball.system.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import mvcbaseball.model.Ball;
import mvcbaseball.model.TripleBalls;

public class RandomTripleBallsGenerator {
    private static Random random = ThreadLocalRandom.current();

    public static TripleBalls generate() {
        List<Integer> randomNumbers = generateThreeRandomNumbers();
        return new TripleBalls(
                Arrays.asList(new Ball(0, randomNumbers.get(0)), new Ball(1, randomNumbers.get(1)),
                        new Ball(2, randomNumbers.get(2)))
        );
    }

    private static List<Integer> generateThreeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != 3) {
            int pickedNumber = random.nextInt(1, 10);
            if (numbers.contains(pickedNumber)) {
                continue;
            }
            numbers.add(pickedNumber);
        }
        return numbers;
    }
}
