package mvcpattern.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import mvcpattern.converter.StringToPairMatchingInfo;
import mvcpattern.model.Mission;
import mvcpattern.model.PairMatchingInfo;

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
