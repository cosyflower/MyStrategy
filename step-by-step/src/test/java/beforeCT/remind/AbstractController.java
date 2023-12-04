package beforeCT.remind;

import java.util.Map;

public abstract class AbstractController implements CommonController {
    //    private final CommonOutputView outputView;
    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            doProcess();
        }
    }

    abstract void doProcess();
}
