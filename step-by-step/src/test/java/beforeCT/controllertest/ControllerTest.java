package beforeCT.controllertest;

import org.junit.jupiter.api.Test;

public class ControllerTest {
    @Test
    void 직접_호출_인자_없이_가능() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockController mockController = new MockController();

                    mockController.callDirectStaticFunctionWithoutArguments();
                    mockController.callDirectStaticFunctionWithoutArguments();
                    mockController.callDirectStaticFunctionWithoutArguments();
                    mockController.callDirectStaticFunctionWithoutArguments();
                }
                , 2, 4, 10, 15
        );
    }

    @Test
    void 직접_호출_하지만_인자_전달_가능() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockController mockController = new MockController();

                    mockController.callDirectStaticFunctionWithArguments(10, 20);
                    mockController.callDirectStaticFunctionWithArguments(10, 20);
                    mockController.callDirectStaticFunctionWithArguments(10, 20);
                    mockController.callDirectStaticFunctionWithArguments(10, 20);
                }
                , 2, 4, 10, 15
        );
    }

    @Test
    void 생성된_객체에서_다른_Static_함수에_포함된_상태에서_호출_불가능() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockController mockController = new MockController();

                    mockController.callOutsideStaticFunctionFromInstance();
                    mockController.callOutsideStaticFunctionFromInstance();

                }
                , 2, 4, 10, 15
        );
    }

    @Test
    void 같은_Class_다른_Static_함수에서_Veri_호출하면_실행조차_안된다() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockRandom.callFuncForTest(100, 2000);
                    MockRandom.callFuncForTest(100, 2000);
                    MockRandom.callFuncForTest(100, 2000);
                    MockRandom.callFuncForTest(100, 2000);
                }
                , 2, 4, 10, 15
        );
    }

    @Test
    void 직접_Static_함수_호출_가() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    int mockA = MockRandom.pickRandomNumberInRange(100, 2000);
                    System.out.println("mockA = " + mockA);

                    int mockB = MockRandom.pickRandomNumberInRange(100, 2000);
                    System.out.println("mockB = " + mockB);

                    int mockC = MockRandom.pickRandomNumberInRange(100, 2000);
                    System.out.println("mockC = " + mockC);

                    int mockD = MockRandom.pickRandomNumberInRange(100, 2000);
                    System.out.println("mockD = " + mockD);
                    ;
                }
                , 2, 4, 10, 15
        );
    }

    @Test
    void 다른_클래스_함수_호출_가능() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockUtil.mockUtil_Call_Veri();
                    MockUtil.mockUtil_Call_Veri();
                    MockUtil.mockUtil_Call_Veri();
                    MockUtil.mockUtil_Call_Veri();
                },
                2, 4, 100, 200);
    }

    @Test
    void 생성된_객체_내부_인스턴스_메서드에서_다른_클래스_함수_호출_가능() {
        SimpleAssertion.pickRandomNumber(
                () -> {
                    MockController mockController = new MockController();

                    mockController.callVeriFunctionFromOtherClass();
                    mockController.callVeriFunctionFromOtherClass();
                    mockController.callVeriFunctionFromOtherClass();
                    mockController.callVeriFunctionFromOtherClass();
                },
                2, 4, 100, 200);
    }
}
