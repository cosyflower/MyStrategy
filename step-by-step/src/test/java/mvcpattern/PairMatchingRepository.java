package mvcpattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvcpattern.model.Pair;
import mvcpattern.model.PairMatchingInfo;

public class PairMatchingRepository {
    public final Map<PairMatchingInfo, List<Pair>> pairMatchingRepository = new HashMap<>();

    public void save(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        pairMatchingRepository.put(pairMatchingInfo, pairs);
    }
}
