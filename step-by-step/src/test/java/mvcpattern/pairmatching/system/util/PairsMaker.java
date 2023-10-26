package mvcpattern.pairmatching.system.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mvcpattern.pairmatching.model.Crew;
import mvcpattern.pairmatching.model.Pair;

public class PairsMaker {
    public List<Pair> makePairs(List<Crew> shuffledCrews) {
        // 2명씩 끊어서 진행한다
        List<Pair> pairs = new ArrayList<>();
        while (shuffledCrews.size() >= 2) {
            List<Crew> crews = getMatchedCrews(shuffledCrews);
            pairs.add(new Pair(crews));
        }
        return pairs;
    }

    private List<Crew> getMatchedCrews(List<Crew> shuffledCrews) {
        List<Crew> matchedPair = Arrays.asList(shuffledCrews.remove(0), shuffledCrews.remove(0));
        handleOddCrewSizeCase(shuffledCrews, matchedPair);
        return matchedPair;
    }

    private void handleOddCrewSizeCase(List<Crew> shuffledCrews, List<Crew> matchedPair) {
        if (shuffledCrews.size() == 1) {
            Crew oddCrew = shuffledCrews.remove(0);
            matchedPair.add(oddCrew);
        }
    }
}
