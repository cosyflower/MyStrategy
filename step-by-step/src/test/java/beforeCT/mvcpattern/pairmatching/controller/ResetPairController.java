package beforeCT.mvcpattern.pairmatching.controller;

import beforeCT.mvcpattern.pairmatching.repository.PairMatchingRepository;
import java.util.Map;
import beforeCT.mvcpattern.pairmatching.view.outputview.OutputView;

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
