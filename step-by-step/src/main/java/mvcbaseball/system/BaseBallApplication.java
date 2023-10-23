package mvcbaseball.system;

import java.util.HashMap;
import java.util.Map;
import mvcbaseball.controller.Controller;
import mvcbaseball.controller.GameStartController;
import mvcbaseball.view.outputview.GameStartOutputView;

public class BaseBallApplication {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public BaseBallApplication() {
        controllerMap.put("gameStart", new GameStartController(new GameStartOutputView()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        initGame(model);
    }

    private void initGame(Map<String, Object> model) {
        controllerMap.get("gameStart").process(model);
    }
}
