package mvcpattern.controller;

import java.util.Map;
import mvcpattern.model.FeatureCommand;
import mvcpattern.view.InputView;
import mvcpattern.view.OutputView;

public class SelectingFeatureController implements Controller { // 기능을 출력한다
    private final OutputView outputView;
    private final InputView<FeatureCommand> inputView;

    public SelectingFeatureController(OutputView outputView, InputView<FeatureCommand> inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    public void process(Map<String, Object> model) { // 기능을 출력하고, 사용자로 부터 입력을 받아야 한다
        outputView.print(model);
        model.put("featureCommand", inputView.getInput()); // String 어떠한 정보, 그에 대응하는 value 가 같이 들어간다
    }
}
