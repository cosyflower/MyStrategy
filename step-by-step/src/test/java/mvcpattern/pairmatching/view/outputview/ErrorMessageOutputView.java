package mvcpattern.pairmatching.view.outputview;

import java.util.Map;

public class ErrorMessageOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        System.out.println(model.get("errorMessage"));
    }
}
