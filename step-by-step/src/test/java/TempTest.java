import java.util.List;
import mvcbaseball.model.Ball;
import mvcbaseball.model.TripleBalls;
import mvcbaseball.system.converter.InputToTripleBallsConverter;
import mvcbaseball.system.util.RandomTripleBallsGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TempTest {
    @Test
    void convert() {
        TripleBalls convert = InputToTripleBallsConverter.convert("123");
        Assertions.assertThat(convert.getTripleBalls()).containsExactly(
                new Ball(0, 1), new Ball(1, 2), new Ball(2, 3)
        );
    }

    @Test
    void generate() {
        TripleBalls generate = RandomTripleBallsGenerator.generate();
        List<Ball> tripleBalls = generate.getTripleBalls();
        for (Ball tripleBall : tripleBalls) {
            System.out.println("tripleBall.getDigit() = " + tripleBall.getDigit());
            System.out.println("tripleBall.getValue() = " + tripleBall.getValue());
        }
    }

    @Test
    void compare() {

        TripleBalls myTripleBalls = InputToTripleBallsConverter.convert("456");
        TripleBalls randomBalls = InputToTripleBallsConverter.convert("000");

        List<Ball> tripleBalls = randomBalls.getTripleBalls();

        for (Ball tripleBall : tripleBalls) {
            System.out.println("tripleBall.getDigit() = " + tripleBall.getDigit()
                    + "tripleBall.getValue() = " + tripleBall.getValue());
        }

        List<Integer> integers = myTripleBalls.compareTripleBallCondition(randomBalls);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
