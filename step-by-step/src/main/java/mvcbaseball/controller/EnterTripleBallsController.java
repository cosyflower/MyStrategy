package mvcbaseball.controller;

import java.util.Map;
import mvcbaseball.model.TripleBalls;
import mvcbaseball.view.inputview.InputView;
import mvcbaseball.view.outputview.OutputView;

public class EnterTripleBallsController extends AbstractController {
    private final OutputView outputView;
    private final InputView<TripleBalls> inputView;

    public EnterTripleBallsController(OutputView outputView,
                                      InputView<TripleBalls> inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        model.put("inputNumberPath", "숫자를 입력해주세요");
        outputView.print(model);

        model.put("userTripleBalls", inputView.input(model));
    }
}
