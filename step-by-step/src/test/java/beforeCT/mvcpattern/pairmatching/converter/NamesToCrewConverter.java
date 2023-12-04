package beforeCT.mvcpattern.pairmatching.converter;

import java.util.List;
import java.util.stream.Collectors;
import beforeCT.mvcpattern.pairmatching.model.Course;
import beforeCT.mvcpattern.pairmatching.model.Crew;

public class NamesToCrewConverter {
    public static List<Crew> convert(List<String> readBackEndCrewNames, Course backend) {
        // 항상 변화할 때 검증이 필요하다
        return readBackEndCrewNames.stream()
                .map(crewName -> new Crew(crewName, backend))
                .collect(Collectors.toList());
    }
}
