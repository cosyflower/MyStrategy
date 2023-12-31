package mvcbaseball.controller;

import java.util.Map;
import mvcbaseball.view.inputview.InputView;
import mvcbaseball.view.outputview.OutputView;

public class GameRestartController extends AbstractController {
    private final OutputView outputView;
    private final InputView inputView;

    public GameRestartController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        model.put("gameEnd", "3개의 숫자 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        outputView.print(model);

        model.put("restartChoice", inputView.input(model));
    }
}
