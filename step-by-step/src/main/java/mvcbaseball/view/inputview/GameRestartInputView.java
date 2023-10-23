package mvcbaseball.view.inputview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class GameRestartInputView implements InputView<String> {
    @Override
    public String input(Map<String, Object> model) {
        try {
            String inputLine = readInput();
            return inputLine;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    protected String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
