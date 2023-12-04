package latestgrammar;

public class TargetClass {
    private final String name;
    private final int code;

    private TargetClass(final String name, final int code) {
        this.name = name;
        this.code = code;
    }

    public static TargetClass of(String name, int code) {
        return new TargetClass(name, code);
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
