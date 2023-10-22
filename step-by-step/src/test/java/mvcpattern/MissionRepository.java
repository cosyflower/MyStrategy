package mvcpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mvcpattern.model.Level;
import mvcpattern.model.Mission;

public class MissionRepository {
    private List<Mission> missions = new ArrayList<>();

    public void saveAllNamesWithLevel(List<String> missionNames, Level level) {
        List<Mission> collectedMission = missionNames.stream()
                .map(name -> new Mission(level, name))
                .collect(Collectors.toList());

        missions.addAll(collectedMission);
    }
}
