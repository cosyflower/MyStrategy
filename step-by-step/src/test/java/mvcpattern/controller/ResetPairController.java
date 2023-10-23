package mvcpattern.controller;

import java.util.Map;
import mvcpattern.repository.PairMatchingRepository;
import mvcpattern.view.outputview.OutputView;

public class ResetPairController extends AbstractController {
    public final PairMatchingRepository pairMatchingRepository;
    public final OutputView outputView;

    public ResetPairController(PairMatchingRepository pairMatchingRepository,
                               OutputView outputView) {
        this.pairMatchingRepository = pairMatchingRepository;
        this.outputView = outputView;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        pairMatchingRepository.resetAll();
        outputView.print(model);

    }
}
