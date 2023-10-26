package mvcpattern.pairmatching.converter;

import java.util.Arrays;
import mvcpattern.pairmatching.model.FeatureCommand;

public class StringToFeatureCommandConverter {

    public static FeatureCommand convert(String input) {
        // FeatureCommand.values()
        // filter .getCommand 비교하기
        return Arrays.stream(FeatureCommand.values())
                .filter(command -> input.equals(command.getCommand()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 커맨드를 입력했음!"));
    }
}
