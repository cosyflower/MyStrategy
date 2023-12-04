package beforeCT.requestTemplate;

import org.junit.jupiter.api.Test;

public class AppTest {
    private AddedClass addedClass;

    @Test
    void run_Configure() {
        setUp();
        execute();
        terminate();
    }

    private void terminate() {
    }

    private void setUp() {
        // 구성 1
        // 구성 2
        // 구성 1과 2 로 구성된 AddedClass
    }

    private void execute() {
        // 핵심 프로그램인 AddedClass의 function()을 호출한다
        // 먼저 사용자로 부터 입력을 받는다
        SpecificClass specificClass = new RequestWithNewClass("inputValue").toSpecificClass();

//        if (ComposedB.findComposedB(specificClass) == ComposedB.LEVEL_1) {
//            // addedClass.createPair()
//        }

        // addedClass.findPair()
        // addedClass.resetPair()
//        if () {
//            terminate();
//        }
    }
}
