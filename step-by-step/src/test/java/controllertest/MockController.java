package controllertest;


public class MockController {
    // Test Code
    // static method가 아닌 일반 인스턴스에서 Verfication으로 지정한 메서드를 호출했을시
    // 정상적으로 내가 설정한 값이 도출되는 모습을 확인했다
    public void callDirectStaticFunctionWithoutArguments() {
        int picked = MockRandom.pickRandomNumberInRange(20, 30);
        System.out.println("picked = " + picked);
    }


    public void callDirectStaticFunctionWithArguments(int a, int b) {
        int pickedWithArguments = MockRandom.pickRandomNumberInRange(a, b);

        System.out.println("pickedWithArguments = " + pickedWithArguments);
    }

    public void callOutsideStaticFunctionFromInstance() {
        System.out.println("callAssertFromInstance() called");
        MockRandom.callFuncForTest(20, 30);
    }

    public void callVeriFunctionFromOtherClass() {
        MockUtil.mockUtil_Call_Veri();
    }
}
