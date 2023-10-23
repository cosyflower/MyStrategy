package mvcpattern.controller;

import java.util.Map;
import mvcpattern.model.PairMatchingInfo;
import mvcpattern.repository.PairMatchingRepository;
import mvcpattern.view.outputview.OutputView;

public class FindPairController implements Controller {
    public final OutputView outputView;
    public final PairMatchingRepository pairMatchingRepository;

    public FindPairController(OutputView outputView, PairMatchingRepository pairMatchingRepository) {
        this.outputView = outputView;
        this.pairMatchingRepository = pairMatchingRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        model.put("machedPairNames", pairMatchingRepository.findAllPairNamesByPairMatchingInfo(pairMatchingInfo));

        outputView.print(model);
    }
}
