package mvcpattern.pairmatching.model;

import java.util.Objects;

public class Mission {
    private final Level level;
    private final String missionName;

    public Mission(Level level, String missionName) {
        this.level = level;
        this.missionName = missionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission = (Mission) o;
        return getLevel() == mission.getLevel() && Objects.equals(getMissionName(), mission.getMissionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLevel(), getMissionName());
    }

    public Level getLevel() {
        return level;
    }

    public String getMissionName() {
        return missionName;
    }
}
