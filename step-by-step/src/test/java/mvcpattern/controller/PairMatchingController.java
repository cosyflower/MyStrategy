package mvcpattern.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mvcpattern.CrewRepository;
import mvcpattern.PairMatchingRepository;
import mvcpattern.model.Crew;
import mvcpattern.model.Pair;
import mvcpattern.model.PairMatchingInfo;
import mvcpattern.system.util.PairsMaker;

public class PairMatchingController implements Controller {
    private final CrewRepository crewRepository;
    private final PairMatchingRepository pairMatchingRepository;
    private final PairsMaker pairsMaker;

    public PairMatchingController(CrewRepository crewRepository, PairMatchingRepository pairMatchingRepository,
                                  PairsMaker pairsMaker) {
        this.crewRepository = crewRepository;
        this.pairMatchingRepository = pairMatchingRepository;
        this.pairsMaker = pairsMaker;
    }

    @Override
    public void process(Map<String, Object> model) {
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
    }

    private List<Crew> getShuffledCrews(List<Crew> foundCrews) {
        List<Crew> crews = new ArrayList<>(foundCrews);
        Collections.shuffle(crews);
        return crews;
    }
}
