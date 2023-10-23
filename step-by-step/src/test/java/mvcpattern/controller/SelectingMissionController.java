package mvcpattern.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mvcpattern.MissionRepository;
import mvcpattern.model.Course;
import mvcpattern.model.Level;
import mvcpattern.view.InputView;
import mvcpattern.view.OutputView;

public class SelectingMissionController implements Controller {
    private final OutputView outputView;
    private final InputView inputView;
    private final MissionRepository missionRepository;

    public SelectingMissionController(OutputView outputView, InputView inputView,
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
    }

    private void putCourseNamesToModel(Map<String, Object> model) {
        List<String> courseNames = Arrays.stream(Course.values())
                .map(course -> course.getCourseName())
                .collect(Collectors.toList());
        model.put("courseNamse", courseNames);
    }

    private void putMissionNamesToModel(Map<String, Object> model) {
        model.put("level1missions", missionRepository.findAllNamesByEachLevel(Level.ONE));
        model.put("level2missions", missionRepository.findAllNamesByEachLevel(Level.TWO));
        model.put("level3missions", missionRepository.findAllNamesByEachLevel(Level.THREE));
        model.put("level4missions", missionRepository.findAllNamesByEachLevel(Level.FOUR));
        model.put("level5missions", missionRepository.findAllNamesByEachLevel(Level.FIVE));
    }


}
