package beforeCT.mvcpattern.pairmatching.view.outputview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import beforeCT.mvcpattern.pairmatching.model.Level;

public class SelectingMissionOutputView implements OutputView {

    public static final String SEPARATOR_FORMAT = " %s ";
    public static final String VALUE_SEPARATOR = "|";
    public static final String SELECT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
    public static final String COURSE_LEVEL_MISSION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

    private static final String PRINTING_COURSE_PREFIX = "과정:";
    private static final String MISSION_MESSAGE_PREFIX = "미션:";

    @Override
    public void print(Map<String, Object> model) {
        printLineSeparator();
        printCourses((List<String>) model.get("courseNames"));
        printMissions(model);
        printLineSeparator();
        printSelectCourseLevelMissionNameMessage();
    }

    private void printSelectCourseLevelMissionNameMessage() {
        System.out.println(SELECT_COURSE_LEVEL_MISSION_MESSAGE);
        System.out.println(COURSE_LEVEL_MISSION_EXAMPLE);
    }

    private void printMissions(Map<String, Object> model) {
        System.out.println(MISSION_MESSAGE_PREFIX);
        printMissionsOfEachLevel(Level.ONE, (List<String>) model.get("level1Missions"));
        printMissionsOfEachLevel(Level.TWO, (List<String>) model.get("level2Missions"));
        printMissionsOfEachLevel(Level.THREE, (List<String>) model.get("level3Missions"));
        printMissionsOfEachLevel(Level.FOUR, (List<String>) model.get("level4Missions"));
        printMissionsOfEachLevel(Level.FIVE, (List<String>) model.get("level5Missions"));
    }

    private void printMissionsOfEachLevel(Level level, List<String> missionsEachLevel) {
        System.out.printf("  - %s: ", level.getLevelDescription());
        printValues(missionsEachLevel);
    }

    private void printCourses(List<String> courseNames) {
        System.out.println(PRINTING_COURSE_PREFIX);
        printValues(courseNames);
    }

    private void printLineSeparator() {
        System.out.println("############################");
    }

    private void printValues(List<String> values) {
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                addSeparator(VALUE_SEPARATOR);
            }
        }
        System.out.println();
    }

    private void addSeparator(String next) {
        System.out.printf(SEPARATOR_FORMAT, next);
    }
}
