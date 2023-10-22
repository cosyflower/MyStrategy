package mvcpattern.view;

import java.util.Map;

public interface OutputView {
    void print(Map<String, Object> model);
}
