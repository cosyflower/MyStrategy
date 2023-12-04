package requestTemplate;

public class AddedClass {
    private final ComposedA composedA;
    private final ComposedB composedB;

    public AddedClass(String[] aAndBValue) {
        this.composedA = ComposedA.findComposedAByName(aAndBValue[0]);
        this.composedB = ComposedB.findComposedB(aAndBValue[1]);
    }
}
