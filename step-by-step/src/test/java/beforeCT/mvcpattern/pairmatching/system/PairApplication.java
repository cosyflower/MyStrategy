package beforeCT.mvcpattern.pairmatching.system;

import beforeCT.mvcpattern.pairmatching.controller.Controller;
import beforeCT.mvcpattern.pairmatching.controller.FindPairController;
import beforeCT.mvcpattern.pairmatching.controller.PairMatchingController;
import beforeCT.mvcpattern.pairmatching.controller.ReadingCrewFileController;
import beforeCT.mvcpattern.pairmatching.controller.ResetPairController;
import beforeCT.mvcpattern.pairmatching.controller.SavingMissionsController;
import beforeCT.mvcpattern.pairmatching.controller.SelectingFeatureController;
import beforeCT.mvcpattern.pairmatching.controller.SelectingMissionController;
import beforeCT.mvcpattern.pairmatching.model.FeatureCommand;
import beforeCT.mvcpattern.pairmatching.repository.CrewRepository;
import beforeCT.mvcpattern.pairmatching.repository.MissionRepository;
import beforeCT.mvcpattern.pairmatching.repository.PairMatchingRepository;
import beforeCT.mvcpattern.pairmatching.system.util.PairsMaker;
import beforeCT.mvcpattern.pairmatching.view.inputview.GettingFeatureInputView;
import beforeCT.mvcpattern.pairmatching.view.inputview.SelectingMissionInputView;
import beforeCT.mvcpattern.pairmatching.view.outputview.MatchingResultOutputView;
import beforeCT.mvcpattern.pairmatching.view.outputview.ResetOutputView;
import beforeCT.mvcpattern.pairmatching.view.outputview.SelectingFeatureOutputView;
import beforeCT.mvcpattern.pairmatching.view.outputview.SelectingMissionOutputView;
import java.util.HashMap;
import java.util.Map;

public class PairApplication {
    public static final String READ_CREW_FILE = "readCrewFile";
    public static final String SAVE_MISSIONS = "saveMissions";
    public static final String SELECT_FEATURE = "selectFeature";
    public static final String SELECT_MISSION = "selectMission";
    private static final String MATCH_PAIR = "matchPair";
    public static final String FIND_PAIR = "findPair";
    public static final String RESET = "reset";

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public PairApplication() {
        CrewRepository crewRepository = new CrewRepository();
        MissionRepository missionRepository = new MissionRepository();
        PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();
        MatchingResultOutputView matchingResultOutputView = new MatchingResultOutputView();

        controllerMap.put(READ_CREW_FILE, new ReadingCrewFileController(crewRepository));
        controllerMap.put(SAVE_MISSIONS, new SavingMissionsController(missionRepository));
        controllerMap.put(SELECT_FEATURE, new SelectingFeatureController(
                new SelectingFeatureOutputView(), new GettingFeatureInputView()));
        controllerMap.put(SELECT_MISSION, new SelectingMissionController(
                new SelectingMissionOutputView(), new SelectingMissionInputView(), missionRepository
        ));
        controllerMap.put(MATCH_PAIR, new PairMatchingController(crewRepository,
                pairMatchingRepository, new PairsMaker(), matchingResultOutputView));

        // 기존에 정의했던 활동을 그대로 반영할 수 있다는 것
        // 객체 지향 프로그래밍의 진정한 장점이라고 생각할 수 있겠다
        controllerMap.put(FIND_PAIR, new FindPairController(matchingResultOutputView, pairMatchingRepository));
        controllerMap.put(RESET, new ResetPairController(pairMatchingRepository, new ResetOutputView()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
        saveMissions(model);

        FeatureCommand featureCommand;
        do {
            readFeatureCommand(model);
            featureCommand = (FeatureCommand) model.get("featureCommand");
            doFeature(featureCommand, model);
        } while (featureCommand != FeatureCommand.QUIT);
    }

    private void readFeatureCommand(Map<String, Object> model) {
        controllerMap.get(SELECT_FEATURE).process(model);
    }

    private void doFeature(FeatureCommand featureCommand, Map<String, Object> model) {
        // 최종 controller 들을 관리하는 Application 이라는 걸 다시 느낄 수 있다
        if (featureCommand == FeatureCommand.MATCHING) {
            controllerMap.get(SELECT_MISSION).process(model);
            controllerMap.get(MATCH_PAIR).process(model);
        }

        if (featureCommand == FeatureCommand.FIND) {
            // 페어 조회를 하는 상황
            controllerMap.get(SELECT_MISSION).process(model); // 과정, 미션 설명하는 과정이 우선적으로 필요하다
            controllerMap.get(FIND_PAIR).process(model);
        }

        if (featureCommand == FeatureCommand.RESET) {
            controllerMap.get(RESET).process(model);
        }
    }

    private void saveMissions(Map<String, Object> model) {
        controllerMap.get(SAVE_MISSIONS).process(model);

    }

    private void readFileAndSaveCrews(Map<String, Object> model) {
        controllerMap.get(READ_CREW_FILE).process(model);
    }
}
