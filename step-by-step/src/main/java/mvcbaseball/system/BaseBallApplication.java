package mvcbaseball.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvcbaseball.controller.Controller;
import mvcbaseball.controller.EnterTripleBallsController;
import mvcbaseball.controller.GameRestartController;
import mvcbaseball.controller.GameResultController;
import mvcbaseball.controller.GameStartController;
import mvcbaseball.system.util.RandomTripleBallsGenerator;
import mvcbaseball.view.inputview.EnterTripleBallsInputView;
import mvcbaseball.view.inputview.GameRestartInputView;
import mvcbaseball.view.outputview.EnterTripleBallsOutputView;
import mvcbaseball.view.outputview.GameRestartOutputView;
import mvcbaseball.view.outputview.GameResultOutputView;
import mvcbaseball.view.outputview.GameStartOutputView;

public class BaseBallApplication {
    public static final String GAME_START_PATH = "gameStart";
    public static final String ENTER_TRIPLE_BALLS_PATH = "enterTripleBalls";
    public static final String GAME_RESULT_PATH = "gameResult";
    public static final String GAME_RESTART = "gameRestart";

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public BaseBallApplication() {
        controllerMap.put(GAME_START_PATH, new GameStartController(new GameStartOutputView()));
        controllerMap.put(ENTER_TRIPLE_BALLS_PATH, new EnterTripleBallsController(
                new EnterTripleBallsOutputView(), new EnterTripleBallsInputView()
        ));
//        controllerMap.put(GAME_RESULT_PATH, new GameResultController(new GameResultOutputView(),
//                RandomTripleBallsGenerator.generate()));
        controllerMap.put(GAME_RESTART, new GameRestartController(new GameRestartOutputView(),
                new GameRestartInputView()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        initGame(model);

        startGame(model);
    }

    private void startGame(Map<String, Object> model) {
        String restartChoice;
        do {
            controllerMap.put(GAME_RESULT_PATH, new GameResultController(new GameResultOutputView(),
                    RandomTripleBallsGenerator.generate()));
            playGame(model);
            restartChoice = (String) model.get("restartChoice");
        } while (isRestart(restartChoice));

    }

    private void playGame(Map<String, Object> model) {
        do {
            enterTripleBalls(model);
            getGameResult(model);
        } while (!hasThreeStrikes(model));

        getRestartChoice(model);
    }

    private boolean isRestart(String restartChoice) {
        if (restartChoice.equals("1")) {
            return true;
        }
        return false;
    }

    private void getRestartChoice(Map<String, Object> model) {
        controllerMap.get(GAME_RESTART).process(model);
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
