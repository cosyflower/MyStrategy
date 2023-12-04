package beforeCT.mvcpattern.pairmatching.view.outputview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingResultOutputView implements OutputView {

    public static final String SEPARATOR_FORMAT = " %s ";
    public static final String SEPARATOR = ":";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println("페어 매칭 결과입니다");
        for (List<String> pairNames : (List<List<String>>) model.get("matchedPairNames")) {
            printValues(pairNames);
        }

    }

    private void printValues(List<String> pairNames) {
        Iterator<String> iterator = pairNames.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                addSeparator();
            }
        }
    }

    private void addSeparator() {
        System.out.printf(SEPARATOR_FORMAT, SEPARATOR);
    }
}
