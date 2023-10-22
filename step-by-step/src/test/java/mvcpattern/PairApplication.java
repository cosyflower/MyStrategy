package mvcpattern;

import java.util.HashMap;
import java.util.Map;
import mvcpattern.controller.Controller;
import mvcpattern.controller.ReadingCrewFileController;

public class PairApplication {
    public static final String READ_CREW_FILE = "readCrewFile";
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public PairApplication() {
        controllerMap.put(READ_CREW_FILE, new ReadingCrewFileController(new CrewRepository()));
    }

    public void run() {
        Map<String, Object> model = new HashMap<>();
        readFileAndSave(model);
    }

    private void readFileAndSave(Map<String, Object> model) {
        controllerMap.get(READ_CREW_FILE).process(model);
    }
}
