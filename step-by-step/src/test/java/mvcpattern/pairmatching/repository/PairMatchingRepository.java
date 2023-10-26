package mvcpattern.pairmatching.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mvcpattern.pairmatching.exception.DuplicationPairsException;
import mvcpattern.pairmatching.exception.EmptyPairMatchingInfoException;
import mvcpattern.pairmatching.model.Level;
import mvcpattern.pairmatching.model.Pair;
import mvcpattern.pairmatching.model.PairMatchingInfo;

public class PairMatchingRepository {
    public final Map<PairMatchingInfo, List<Pair>> pairMatchingRepository = new HashMap<>();

    public void save(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        pairMatchingRepository.put(pairMatchingInfo, pairs);
    }

    public boolean hasDuplicatedPairAtSameLevel(PairMatchingInfo pairMatchingInfo, List<Pair> pairs) {
        List<List<Pair>> matchedPairsAtSameLevel = findAllByLevel(pairMatchingInfo.getLevel());
        try {
            checkHavingDuplicatedPairs(matchedPairsAtSameLevel, pairs);
        } catch (DuplicationPairsException e) { // exception 이 잡힌 것은 중복되었다는 사실
            return true;
        }
        return false;
    }

    private void checkHavingDuplicatedPairs(List<List<Pair>> matchedPairsAtSameLevel, List<Pair> pairs)
            throws DuplicationPairsException {
        // 같은 Level 모든 집, 내가 만든 pairs
        for (List<Pair> matchedPairAtSameLevel : matchedPairsAtSameLevel) {
            checkDuplicationByEachPairMatching(matchedPairAtSameLevel, pairs);
        }
    }

    private void checkDuplicationByEachPairMatching(List<Pair> matchedPairAtSameLevel, List<Pair> pairs)
            throws DuplicationPairsException {
        // 두 개를 서로 비교해야 한다
        for (Pair matchedPair : matchedPairAtSameLevel) {
            checkDuplication(matchedPair, pairs);
        }
    }

    private void checkDuplication(Pair matchedpair, List<Pair> pairs) throws DuplicationPairsException {
        if (pairs.contains(matchedpair)) {
            throw new DuplicationPairsException();
        }
    }

    private List<List<Pair>> findAllByLevel(Level level) {
        // Stream 생각 없으면 그냥 하나 만드는게 베스트
        List<List<Pair>> matchedPairsAtSameLevels = new ArrayList<>();
        getPairsAtSameLevel(matchedPairsAtSameLevels, level);
        return matchedPairsAtSameLevels;
    }

    private void getPairsAtSameLevel(List<List<Pair>> matchedPairsAtSameLevels, Level level) {
        // Map 의 경우 forEach() 로 접근하자
        pairMatchingRepository.forEach(((pairMatchingInfo, pairs) ->
        {
            if (pairMatchingInfo.getLevel() == level) {
                matchedPairsAtSameLevels.add(pairs);
            }
        }));
    }

    public List<List<String>> findAllPairNamesByPairMatchingInfo(PairMatchingInfo pairMatchingInfo) {
        List<Pair> pairs = findByPairMatchingInfo(pairMatchingInfo);
        if (pairs == null) {
            throw new EmptyPairMatchingInfoException();
        }

        return findAllNamesFromPairs(pairs);
    }

    private static List<List<String>> findAllNamesFromPairs(List<Pair> pairs) {
        List<List<String>> pairNamesFromPairs = new ArrayList<>();
        findAllNamesFromPair(pairNamesFromPairs, pairs);
        return pairNamesFromPairs;
    }

    private static void findAllNamesFromPair(List<List<String>> allNames, List<Pair> pairs) {
        for (Pair pair : pairs) {
            allNames.add(pair.getNames());
        }
    }

    private List<Pair> findByPairMatchingInfo(PairMatchingInfo pairMatchingInfo) {
        return pairMatchingRepository.get(pairMatchingInfo);
    }

    public void resetAll() {
        pairMatchingRepository.clear();
    }
}
