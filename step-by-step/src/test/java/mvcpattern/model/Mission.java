package mvcpattern.model;

public class Mission {
    private final Level level;
    private final String missionName;

    public Mission(Level level, String missionName) {
        this.level = level;
        this.missionName = missionName;
    }

    public Level getLevel() {
        return level;
    }

    public String getMissionName() {
        return missionName;
    }
}
