package beforeCT.requestTemplate;

public class AddedRequest {
    private final String addedRequest; // 백엔드,레벨1 이 입력된 상황이라고 생각하자


    public AddedRequest(String addedRequest) {
        validateAddedRequest(addedRequest); // 검증 완료
        this.addedRequest = addedRequest;
    }

    private void validateAddedRequest(String addedRequest) {

    }

    public AddedClass toAddedClass() {
        String[] split = addedRequest.split(",");
        return new AddedClass(split);
    }
}

