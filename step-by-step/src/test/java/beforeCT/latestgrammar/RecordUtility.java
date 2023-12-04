package beforeCT.latestgrammar;

public record RecordUtility(String key, int value) {
    public static RecordUtility getRecordUtility(TargetClass targetClass) {
        return new RecordUtility(targetClass.getName(), targetClass.getCode());
    }
}
