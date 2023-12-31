package mvcpattern.pairmatching.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mvcpattern.pairmatching.model.Crew;
import mvcpattern.pairmatching.model.Pair;
import mvcpattern.pairmatching.model.PairMatchingInfo;
import mvcpattern.pairmatching.repository.CrewRepository;
import mvcpattern.pairmatching.repository.PairMatchingRepository;
import mvcpattern.pairmatching.system.util.PairsMaker;
import mvcpattern.pairmatching.view.outputview.OutputView;

public class PairMatchingController extends AbstractController {
    private final CrewRepository crewRepository;
    private final PairMatchingRepository pairMatchingRepository;
    private final PairsMaker pairsMaker;
    private final OutputView outputView;

    public PairMatchingController(CrewRepository crewRepository, PairMatchingRepository pairMatchingRepository,
                                  PairsMaker pairsMaker, OutputView outputView) {
        this.crewRepository = crewRepository;
        this.pairMatchingRepository = pairMatchingRepository;
        this.pairsMaker = pairsMaker;
        this.outputView = outputView;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        List<Crew> foundCrews = crewRepository.findCrewsByCourse(pairMatchingInfo.getCourse());

        // PairMatchingRepository에서 조회를 해야 한다 - 인자로는 pairMatchingInfo 가 필요하고, pairs(내가 만든 페어) 필요하다
        // 동일한 레벨에 있는 각가의 List<Pair> 를 모두 가지고 와야 한다 -> List<List<Pair>> 는 레벨에서 유지하는 페어 그룹들의 그룹
        // PairM..Repo.. 에서 checkDuplicatedPair(pairMatchingInfo, pairs) 해야 한다
        List<Pair> pairs;
        int matchCount = 0;
        do {
            pairs = pairsMaker.makePairs(getShuffledCrews(foundCrews));
            matchCount++;
            if (matchCount == 3) {
                throw new IllegalArgumentException("Shuffle 3회 시도");
            }
        } while (pairMatchingRepository.hasDuplicatedPairAtSameLevel(pairMatchingInfo, pairs));

        pairMatchingRepository.save(pairMatchingInfo, pairs);

        model.put("matchedPairNames", pairMatchingRepository.findAllPairNamesByPairMatchingInfo(pairMatchingInfo));
        outputView.print(model);
    }

    private List<Crew> getShuffledCrews(List<Crew> foundCrews) {
        List<Crew> crews = new ArrayList<>(foundCrews);
        Collections.shuffle(crews);
        return crews;
    }
}
