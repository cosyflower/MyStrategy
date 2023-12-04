package beforeCT.mvcpattern.pairmatching.view.inputview;

import beforeCT.mvcpattern.pairmatching.model.PairMatchingInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import beforeCT.mvcpattern.pairmatching.converter.StringToPairMatchingInfo;
import beforeCT.mvcpattern.pairmatching.model.Mission;

public class SelectingMissionInputView implements InputView<PairMatchingInfo> {

    @Override
    public PairMatchingInfo getInput(Map<String, Object> model) {
        String inputLine = readInput();
        return StringToPairMatchingInfo.convert(inputLine, (List<Mission>) model.get("allMissions"));
    }

    protected String readInput() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
