package beforeCT.mvcpattern.pairmatching.model;

import java.util.Objects;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    public PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairMatchingInfo that = (PairMatchingInfo) o;
        return getCourse() == that.getCourse() && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), mission);
    }

    public Level getLevel() {
        return mission.getLevel();
    }
}
