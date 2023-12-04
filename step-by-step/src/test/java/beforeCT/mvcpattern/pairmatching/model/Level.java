package beforeCT.mvcpattern.pairmatching.model;

public enum Level {
    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String levelDescription;

    Level(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public String getLevelDescription() {
        return levelDescription;
    }
}
