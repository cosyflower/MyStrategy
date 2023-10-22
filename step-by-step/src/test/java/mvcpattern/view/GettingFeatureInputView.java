package mvcpattern.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import mvcpattern.converter.StringToFeatureCommandConverter;
import mvcpattern.model.FeatureCommand;

public class GettingFeatureInputView implements InputView<FeatureCommand> {
    @Override
    public FeatureCommand getInput() {
        String input = readInput();
        return StringToFeatureCommandConverter.convert(input);
    }

    protected String readInput() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
