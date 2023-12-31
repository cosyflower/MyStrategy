package mvcpattern.pairmatching.controller;

import java.util.Map;
import mvcpattern.pairmatching.model.PairMatchingInfo;
import mvcpattern.pairmatching.repository.PairMatchingRepository;
import mvcpattern.pairmatching.view.outputview.OutputView;

public class FindPairController extends AbstractController {
    public final OutputView outputView;
    public final PairMatchingRepository pairMatchingRepository;

    public FindPairController(OutputView outputView, PairMatchingRepository pairMatchingRepository) {
        this.outputView = outputView;
        this.pairMatchingRepository = pairMatchingRepository;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        // 존재하는 경우 추가 처리해야 한다
        model.put("machedPairNames", pairMatchingRepository.findAllPairNamesByPairMatchingInfo(pairMatchingInfo));

        outputView.print(model);
    }
}
