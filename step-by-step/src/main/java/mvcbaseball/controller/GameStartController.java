package mvcbaseball.controller;

import java.util.Map;
import mvcbaseball.view.outputview.OutputView;

public class GameStartController extends AbstractController {
    public static final String GAME_START_PATH = "gameStart";
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final OutputView outputView;

    public GameStartController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        // Game Start 하려고 하는 상황이다
        model.put(GAME_START_PATH, GAME_START_MESSAGE);
        outputView.print(model);
    }
}
