package mvcbaseball.system.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import mvcbaseball.model.Ball;
import mvcbaseball.model.TripleBalls;

public class InputToTripleBallsConverter {
    public static TripleBalls convert(String input) {
//        new TripleBallsValidator(input);
        List<Character> charList = StringToCharList(input);

        return new TripleBalls(
                Arrays.asList(
                        new Ball(0, charToInteger(charList.get(0))),
                        new Ball(1, charToInteger(charList.get(1))),
                        new Ball(2, charToInteger(charList.get(2)))
                )
        );
    }

    private static List<Character> StringToCharList(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
    }

    private static int charToInteger(Character character) {
        return Integer.parseInt(String.valueOf(character));
    }
}
