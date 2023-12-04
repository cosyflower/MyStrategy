package beforeCT.mvcpattern.pairmatching.controller;

import beforeCT.mvcpattern.pairmatching.model.FeatureCommand;
import beforeCT.mvcpattern.pairmatching.view.inputview.InputView;
import beforeCT.mvcpattern.pairmatching.view.outputview.OutputView;
import java.util.Map;

public class SelectingFeatureController extends AbstractController { // 기능을 출력한다
    private final OutputView outputView;
    private final InputView<FeatureCommand> inputView;

    public SelectingFeatureController(OutputView outputView, InputView<FeatureCommand> inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    public void doProcess(Map<String, Object> model) { // 기능을 출력하고, 사용자로 부터 입력을 받아야 한다
        outputView.print(model);
        model.put("featureCommand", inputView.getInput(model)); // String 어떠한 정보, 그에 대응하는 value 가 같이 들어간다
    }
}
