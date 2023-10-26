package mvcpattern.pairmatching.controller;

import java.util.Map;

public interface Controller {
    void process(Map<String, Object> model); // Controller의 역할을 수행하면서 돌려줘야 하는 정보 model 이라고 생각하자
}
