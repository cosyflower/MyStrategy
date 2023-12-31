package mvcbaseball.view.outputview;

import java.util.Map;

public class ErrorMessageOutputView implements OutputView {
    public static final String ERROR_MESSAGE_FORMAT = " %s | %s \n";
    public static final String ERROR_PATH = "errorMessage";

    @Override
    public void print(Map<String, Object> model) {
        String message = (String) model.get(ERROR_PATH);
        System.out.printf(ERROR_MESSAGE_FORMAT, "[ERROR]", message);
    }
}
