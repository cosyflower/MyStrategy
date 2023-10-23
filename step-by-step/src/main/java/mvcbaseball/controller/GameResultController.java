package mvcbaseball.controller;

import java.util.List;
import java.util.Map;
import mvcbaseball.model.TripleBalls;
import mvcbaseball.view.outputview.OutputView;

public class GameResultController extends AbstractController {
    private final OutputView outputView;
    private final TripleBalls computerTripleBalls;

    public GameResultController(OutputView outputView, TripleBalls computerTripleBalls) {
        this.outputView = outputView;
        this.computerTripleBalls = computerTripleBalls;
    }

    @Override
    void doProcess(Map<String, Object> model) {
        TripleBalls tripleBalls = (TripleBalls) model.get("userTripleBalls");
        List<Integer> ballAndStrikeCounts = tripleBalls.compareTripleBallCondition(computerTripleBalls);
        model.put("gameResult", ballAndStrikeCounts);

        outputView.print(model);
    }
}
