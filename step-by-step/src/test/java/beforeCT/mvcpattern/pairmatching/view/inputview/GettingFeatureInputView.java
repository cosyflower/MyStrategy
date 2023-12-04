package beforeCT.mvcpattern.pairmatching.view.inputview;

import beforeCT.mvcpattern.pairmatching.converter.StringToFeatureCommandConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import beforeCT.mvcpattern.pairmatching.model.FeatureCommand;

public class GettingFeatureInputView implements InputView<FeatureCommand> {
    @Override
    public FeatureCommand getInput(Map<String, Object> model) {
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
