package beforeCT.controllertest;

public class MockUtil {
    public static void mockUtil_Call_Veri() {
        int mocked = MockRandom.pickRandomNumberInRange(10, 20);
        System.out.println("mocked = " + mocked);
    }
}
