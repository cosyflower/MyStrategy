package mvcbaseball.view.inputview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import mvcbaseball.model.TripleBalls;
import mvcbaseball.system.converter.InputToTripleBallsConverter;
import mvcbaseball.system.validator.InputNumberValidator;

public class EnterTripleBallsInputView implements InputView<TripleBalls> {
    @Override
    public TripleBalls input(Map<String, Object> model) {
        try {
            String input = readInput();
            new InputNumberValidator(input);
            return InputToTripleBallsConverter.convert(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
