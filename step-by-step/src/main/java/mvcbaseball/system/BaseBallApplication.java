package mvcbaseball.system;

import java.util.HashMap;
import java.util.Map;
import mvcbaseball.controller.Controller;
import mvcbaseball.controller.EnterTripleBallsController;
import mvcbaseball.controller.GameStartController;
import mvcbaseball.view.inputview.EnterTripleBallsInputView;
import mvcbaseball.view.outputview.EnterTripleBallsOutputView;
import mvcbaseball.view.outputview.GameStartOutputView;

public class BaseBallApplication {
    public static final String GAME_START_PATH = "gameStart";
    public static final String ENTER_TRIPLE_BALLS_PATH = "enterTripleBalls";
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public BaseBallApplication() {
        controllerMap.put(GAME_START_PATH, new GameStartController(new GameStartOutputView()));
        controllerMap.put(ENTER_TRIPLE_BALLS_PATH, new EnterTripleBallsController(
                new EnterTripleBallsOutputView(), new EnterTripleBallsInputView()
        ));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        initGame(model);

        enterTripleBalls(model);
    }

    private void enterTripleBalls(Map<String, Object> model) {
        controllerMap.get(ENTER_TRIPLE_BALLS_PATH).process(model);
    }

    private void initGame(Map<String, Object> model) {
        controllerMap.get(GAME_START_PATH).process(model);
    }
}
