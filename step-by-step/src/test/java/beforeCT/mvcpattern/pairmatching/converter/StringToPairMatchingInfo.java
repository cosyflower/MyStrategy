package beforeCT.mvcpattern.pairmatching.converter;

import beforeCT.mvcpattern.pairmatching.model.Course;
import beforeCT.mvcpattern.pairmatching.model.Mission;
import beforeCT.mvcpattern.pairmatching.model.PairMatchingInfo;
import java.util.List;

public class StringToPairMatchingInfo {
    public static PairMatchingInfo convert(String inputLine, List<Mission> allMissions) {
        // inputLine : 프론트엔드, 레벨1, 자동차 경주
        // inputLine을 먼저 쪼개야 한다
        String replacedInput = inputLine.replaceAll(" ", "");
        String[] splitInput = replacedInput.split(",");

        Course foundCourse = getCourse(splitInput[0]);// Course 를 얻어야 하는 상
        Mission foundMission = getMission(allMissions, splitInput);// Mission
        return new PairMatchingInfo(foundCourse, foundMission);
    }

    private static Mission getMission(List<Mission> allMissionNames, String[] splitInput) {
        return allMissionNames.stream()
                .filter(mission -> mission.getLevel().equals(splitInput[1])
                        && mission.getMissionName().equals(splitInput[2]))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    private static Course getCourse(String findingCourse) {
        return Course.findByName(findingCourse);
    }
}
