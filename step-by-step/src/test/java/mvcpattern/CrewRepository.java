package mvcpattern;

import java.util.ArrayList;
import java.util.List;
import mvcpattern.model.Crew;

public class CrewRepository {
    public final List<Crew> crews = new ArrayList<>();

    public void saveAll(List<Crew> backEndCrews) {
        crews.addAll(backEndCrews);
    }
}
