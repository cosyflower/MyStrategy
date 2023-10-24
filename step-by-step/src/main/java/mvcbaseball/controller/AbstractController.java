package mvcbaseball.controller;

import java.util.Map;
import mvcbaseball.view.outputview.ErrorMessageOutputView;
import mvcbaseball.view.outputview.OutputView;

public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorMessageOutputView();

    @Override
    public void process(Map<String, Object> model) {
        // flow 작성하고 model 에 데이터를 저장하고, 행위를 처리하고, 반환된 결과를 model 에 넣어야 한다
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);
            throw new IllegalArgumentException();
        }
    }

    abstract void doProcess(Map<String, Object> model);
}
