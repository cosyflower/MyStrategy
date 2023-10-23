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
        // input으로 들어온 정보를 먼저 확인해야 한다
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        List<Crew> foundCrews = crewRepository.findCrewsByCourse(pairMatchingInfo.getCourse());
        List<Pair> pairs = pairsMaker.makePairs(getShuffledCrews(foundCrews));
        pairMatchingRepository.save(pairMatchingInfo, pairs);
    }

    private List<Crew> getShuffledCrews(List<Crew> foundCrews) {
        List<Crew> crews = new ArrayList<>(foundCrews);
        Collections.shuffle(crews);
        return crews;
    }
}
