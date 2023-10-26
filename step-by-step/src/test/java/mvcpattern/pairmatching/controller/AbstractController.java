package mvcpattern.pairmatching.controller;

import java.util.Map;
import mvcpattern.pairmatching.view.outputview.ErrorMessageOutputView;
import mvcpattern.pairmatching.view.outputview.OutputView;

public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorMessageOutputView();

    @Override
    public void process(Map<String, Object> model) { // 에러가 발생한 상황에 대비하기 위함이다
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);

            doProcess(model);
        }
    }

    abstract void doProcess(Map<String, Object> model);
}
