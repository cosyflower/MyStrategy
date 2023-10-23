package mvcbaseball.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvcbaseball.controller.Controller;
import mvcbaseball.controller.EnterTripleBallsController;
import mvcbaseball.controller.GameResultController;
import mvcbaseball.controller.GameStartController;
import mvcbaseball.system.util.RandomTripleBallsGenerator;
import mvcbaseball.view.inputview.EnterTripleBallsInputView;
import mvcbaseball.view.outputview.EnterTripleBallsOutputView;
import mvcbaseball.view.outputview.GameResultOutputView;
import mvcbaseball.view.outputview.GameStartOutputView;

public class BaseBallApplication {
    public static final String GAME_START_PATH = "gameStart";
    public static final String ENTER_TRIPLE_BALLS_PATH = "enterTripleBalls";
    public static final String GAME_RESULT_PATH = "gameResult";

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public BaseBallApplication() {
        controllerMap.put(GAME_START_PATH, new GameStartController(new GameStartOutputView()));
        controllerMap.put(ENTER_TRIPLE_BALLS_PATH, new EnterTripleBallsController(
                new EnterTripleBallsOutputView(), new EnterTripleBallsInputView()
        ));
        controllerMap.put(GAME_RESULT_PATH, new GameResultController(new GameResultOutputView(),
                RandomTripleBallsGenerator.generate()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        initGame(model);

        do {
            enterTripleBalls(model);
            getGameResult(model);
        } while (!hasThreeStrikes(model));

        System.out.println("GameEnd");
    }

    private boolean hasThreeStrikes(Map<String, Object> model) {
        List<Integer> ballAndStrikeCounts = (List<Integer>) model.get("gameResult");
        return ballAndStrikeCounts.stream()
                .skip(1)
                .allMatch(strikeCount -> strikeCount == 3);
    }

    private void getGameResult(Map<String, Object> model) {
        controllerMap.get(GAME_RESULT_PATH).process(model);
    }

    private void enterTripleBalls(Map<String, Object> model) {
        controllerMap.get(ENTER_TRIPLE_BALLS_PATH).process(model);
    }

    private void initGame(Map<String, Object> model) {
        controllerMap.get(GAME_START_PATH).process(model);
    }
}
