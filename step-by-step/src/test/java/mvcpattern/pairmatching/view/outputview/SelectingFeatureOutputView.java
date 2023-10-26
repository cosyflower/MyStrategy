package mvcpattern.pairmatching.view.outputview;

import java.util.Map;
import mvcpattern.pairmatching.model.FeatureCommand;

public class SelectingFeatureOutputView implements OutputView {
    public static final String FEATURE_FORMAT = "%s.%s\n";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println("기능 선택");
        for (FeatureCommand featureCommand : FeatureCommand.values()) {
            // format에 맞게 진행하고 싶다면 printf() 를 사용할 것
            System.out.printf(FEATURE_FORMAT, featureCommand.getCommand(), featureCommand.getDescription());
        }
    }
}
