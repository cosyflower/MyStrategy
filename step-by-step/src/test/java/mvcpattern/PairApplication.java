package mvcpattern;

import java.util.HashMap;
import java.util.Map;
import mvcpattern.controller.Controller;
import mvcpattern.controller.ReadingCrewFileController;
import mvcpattern.controller.SavingMissionsController;
import mvcpattern.controller.SelectingFeatureController;
import mvcpattern.controller.SelectingMissionController;
import mvcpattern.model.FeatureCommand;
import mvcpattern.view.GettingFeatureInputView;
import mvcpattern.view.SelectingFeatureOutputView;
import mvcpattern.view.SelectingMissionOutputView;

public class PairApplication {
    public static final String READ_CREW_FILE = "readCrewFile";
    public static final String SAVE_MISSIONS = "saveMissions";
    public static final String SELECT_FEATURE = "selectFeature";
    public static final String SELECT_MISSION = "selectMission";

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public PairApplication() {
        controllerMap.put(READ_CREW_FILE, new ReadingCrewFileController(new CrewRepository()));
        controllerMap.put(SAVE_MISSIONS, new SavingMissionsController(new MissionRepository()));
        controllerMap.put(SELECT_FEATURE, new SelectingFeatureController(
                new SelectingFeatureOutputView(), new GettingFeatureInputView()));
        controllerMap.put(SELECT_MISSION, new SelectingMissionController(
                new SelectingMissionOutputView(), null, new MissionRepository()
        ));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        readFileAndSaveCrews(model);
        saveMissions(model);
        getFeatureCommand(model);
    }

    private void doFeature(HashMap<String, Object> model) {
        // 최종 controller 들을 관리하는 Application 이라는 걸 다시 느낄 수 있다
        FeatureCommand featureCommand = (FeatureCommand) model.get("featureCommand");
        if (featureCommand == FeatureCommand.MATCHING) {
            controllerMap.get(SELECT_MISSION).process(model);
        }
        if (featureCommand == FeatureCommand.FIND) {

        }
        if (featureCommand == FeatureCommand.RESET) {

        }
        if (featureCommand == FeatureCommand.QUIT) {

        }
    }

    private void saveMissions(Map<String, Object> model) {
        controllerMap.get(SAVE_MISSIONS).process(model);

    }

    private void getFeatureCommand(Map<String, Object> model) {
        controllerMap.get(SELECT_FEATURE).process(model);
    }

    private void readFileAndSaveCrews(Map<String, Object> model) {
        controllerMap.get(READ_CREW_FILE).process(model);
    }
}
