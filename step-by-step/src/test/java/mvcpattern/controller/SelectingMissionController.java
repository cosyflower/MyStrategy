package mvcpattern.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mvcpattern.model.Course;
import mvcpattern.model.Level;
import mvcpattern.model.PairMatchingInfo;
import mvcpattern.repository.MissionRepository;
import mvcpattern.view.inputview.InputView;
import mvcpattern.view.outputview.OutputView;

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
        // 전체적인 Flow 작성해야 한다
        // OutputView 에서 필요한 정보들을 model 에 담아서 보내준다
        putCourseNamesToModel(model);
        putMissionNamesToModel(model);
        outputView.print(model);

        // InputView 는 입력을 받는다
        // 당연히 String 형태로 받기 때문에 원하는 형태로 변환까지 진행해야 한다
        // 변환에 필요한 정보들을 담아서 View 에게 전달한다
        // View는 정보를 확인하고 원하는 객체 형태로 전환해서 반환한다
        // 반환된 정보 역시 model 에 추가한다
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
