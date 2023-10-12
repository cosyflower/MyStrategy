package myRandom;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static myRandom.MyAssertions.checkMyRandomNumber;
import static myRandom.MyAssertions.checkMyRandomNumbersInRange;
import static myRandom.MyRandom.pickNumberInList;
import static myRandom.MyRandom.pickUniqueNumbersInRange;

public class MyTest {
    @Test
    void Argument_Equals_Random_Number() {
        // RandomGenerator for test code
        checkMyRandomNumber(
                () -> {
                    int pickedA = pickNumberInList(Arrays.asList(1, 2, 3, 4));
                    System.out.println("pickedA = " + pickedA);
                    Assertions.assertThat(pickedA).isEqualTo(100);

                    int pickedB = pickNumberInList(Arrays.asList(1, 2, 3, 8));
                    System.out.println("pickedB = " + pickedB);

                    int pickedC = pickNumberInList(Arrays.asList());
                    System.out.println("pickedC = " + pickedC);

                    int pickedD = pickNumberInList(Arrays.asList(1, 2));
                    System.out.println("pickedD = " + pickedD);
                }
                , 100, 210, 9, 7);
    }

    @Test
    void Argument_Eqauls_Random_Numbers_In_Range() {
        checkMyRandomNumbersInRange(
                () -> {
                    List<Integer> pickedUniqueNumbers = pickUniqueNumbersInRange(1, 10, 1);
                    Assertions.assertThat(pickedUniqueNumbers).containsExactly(1, 2, 3);
                    System.out.println("pickedUniqueNumbers = " + pickedUniqueNumbers);

                    List<Integer> pickedUniqueNumbersB = pickUniqueNumbersInRange(1, 10, 1);
                    Assertions.assertThat(pickedUniqueNumbersB).containsExactly(4, 5, 6);
                    System.out.println("pickedUniqueNumbersB = " + pickedUniqueNumbersB);

                    List<Integer> pickedUniqueNumbersC = pickUniqueNumbersInRange(1, 10, 1);
                    Assertions.assertThat(pickedUniqueNumbersC).containsExactly(7, 8, 9);
                    System.out.println("pickedUniqueNumbersC = " + pickedUniqueNumbersC);

                }, Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)
        );
    }
}
