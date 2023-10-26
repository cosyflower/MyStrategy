package mvcpattern.pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    public List<Crew> crewPair;

    public Pair(List<Crew> crewPair) {
        this.crewPair = crewPair;
    }

    public List<String> getNames() {
        return crewPair.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
