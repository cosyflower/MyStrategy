package mvcbaseball.controller;

import java.util.Map;
import mvcbaseball.view.outputview.ErrorMessageOutputView;
import mvcbaseball.view.outputview.OutputView;

public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorMessageOutputView();

    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);
        }
    }

    abstract void doProcess(Map<String, Object> model);
}
