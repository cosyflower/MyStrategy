package beforeCT.mvcpattern.pairmatching.repository;

import beforeCT.mvcpattern.pairmatching.model.Course;
import beforeCT.mvcpattern.pairmatching.model.Crew;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    public final List<Crew> crews = new ArrayList<>();

    public void saveAll(List<Crew> backEndCrews) {
        crews.addAll(backEndCrews);
    }

    public List<Crew> findCrewsByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse() == course)
                .collect(Collectors.toList());
    }
}
