package mvcpattern.pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import mvcpattern.pairmatching.model.Level;
import mvcpattern.pairmatching.model.Mission;

public class MissionRepository {
    private final List<Mission> missions = new ArrayList<>();

    public void saveAllNamesWithLevel(List<String> missionNames, Level level) {
        List<Mission> collectedMission = missionNames.stream()
                .map(name -> new Mission(level, name))
                .collect(Collectors.toList());

        missions.addAll(collectedMission);
    }

    public List<String> findAllNamesByEachLevel(Level level) {
        return missions.stream()
                .filter(mission -> mission.getLevel() == level)
                .map(mission -> mission.getMissionName())
                .collect(Collectors.toList());
    }

    public List<Mission> findAll() {
        return Collections.unmodifiableList(missions);
    }
}
