package beforeCT.mvcpattern.pairmatching.view.inputview;

import java.util.Map;

public interface InputView<T> {
    T getInput(Map<String, Object> model); // InputView에서 전달하는 model 도 생각해야 한다
}
