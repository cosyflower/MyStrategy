package requestTemplate;

public class RequestWithNewClass { // SpecificClass로 변환하는 메서드까지 확인할 수 있음
    private final String specificRequest;

    public RequestWithNewClass(String specificRequest) {
        this.specificRequest = specificRequest;
    }

    public SpecificClass toSpecificClass() {
        return new SpecificClass(Integer.parseInt(specificRequest));
    }
}
