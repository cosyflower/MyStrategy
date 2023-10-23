package mvcpattern.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mvcpattern.MissionRepository;
import mvcpattern.model.Course;
import mvcpattern.model.Level;
import mvcpattern.model.PairMatchingInfo;
import mvcpattern.view.InputView;
import mvcpattern.view.OutputView;

public class SelectingMissionController implements Controller {
    private final OutputView outputView;
    private final InputView<PairMatchingInfo> inputView;
    private final MissionRepository missionRepository;

    public SelectingMissionController(OutputView outputView, InputView<PairMatchingInfo> inputView,
                                      MissionRepository missionRepository) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.missionRepository = missionRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        putCourseNamesToModel(model);
        putMissionNamesToModel(model);
        outputView.print(model);

        readInputIntoModel(model);
    }

    private void readInputIntoModel(Map<String, Object> model) {
        putAllMissionsToModel(model); // View에서 처리할  접근해야 하는 도메인 관련 데이터는 이 model에 넣어야 하는 것이다
        // model에 먼저 넣어서 보내놓고
        model.put("pairMatchingInfo", inputView.getInput(model)); // InputView -> 입력을 받고 convert까지 진행한 다음 반환한다
        // 반환한 결과 역시 model에 담아서 되돌아온다고 생각한다
    }

    private void putAllMissionsToModel(Map<String, Object> model) {
        model.put("allMissions", missionRepository.findAll());
    }

    private void putCourseNamesToModel(Map<String, Object> model) {
        List<String> courseNames = Arrays.stream(Course.values())
                .map(course -> course.getCourseName())
                .collect(Collectors.toList());
        model.put("courseNames", courseNames);
    }

    private void putMissionNamesToModel(Map<String, Object> model) {
        model.put("level1missions", missionRepository.findAllNamesByEachLevel(Level.ONE));
        model.put("level2missions", missionRepository.findAllNamesByEachLevel(Level.TWO));
        model.put("level3missions", missionRepository.findAllNamesByEachLevel(Level.THREE));
        model.put("level4missions", missionRepository.findAllNamesByEachLevel(Level.FOUR));
        model.put("level5missions", missionRepository.findAllNamesByEachLevel(Level.FIVE));
    }


}
