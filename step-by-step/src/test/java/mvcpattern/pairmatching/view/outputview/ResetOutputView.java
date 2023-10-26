package mvcpattern.pairmatching.view.outputview;

import java.util.Map;

public class ResetOutputView implements OutputView {

    public static final String RESET_PAIR_MATCHING_MESSAGE = "초기화 되었습니다";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(RESET_PAIR_MATCHING_MESSAGE);
    }
}
