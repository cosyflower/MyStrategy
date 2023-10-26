package remind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class IOTemplateTest extends CommonTemplateAboutIO {
    @ParameterizedTest(name = "input : {0}")
    @ValueSource(strings = {"checking", "my", "template"})
    void simple_Argument(String input) throws IOException {
        InputStream inputStream = convertInputToInputStream(input);
        setInGeneratedInputStream(inputStream);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        Assertions.assertThat(readLine).isEqualTo(input);
    }

    @ParameterizedTest(name = "input : {0} ")
    @ValueSource(strings = {"checking multiple\ninputs with\nnew Line"})
    void simple_Sentence_With_New_Line(String sentenceWithNewLine) throws IOException {
        InputStream inputStream = convertInputToInputStream(sentenceWithNewLine);
        setInGeneratedInputStream(inputStream);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine;

        while ((readLine = br.readLine()) != null) {
            System.out.println(readLine);
        }
    }

    private static Stream<Arguments> generateMultipleArguments() {
        return Stream.of(
                Arguments.of("1+1 = ", "2", "Check"),
                Arguments.of("2+2 = ", "4", "Triple"),
                Arguments.of("3+3 = ", "6", "Situation"),
                Arguments.of("4+4 = ", "8", "Moment")
        );
    }

    @ParameterizedTest(name = " expression : {0} and result : {1}, {2}")
    @MethodSource("generateMultipleArguments")
    void multiple_Arguments_With_MethodSource(String exp, String result, String description) throws IOException {
        SequenceInputStream sequenceInputStream = convertMultipleInputsToInputStream(exp, result, description);
        setInGeneratedInputStream(sequenceInputStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String read;
        while ((read = br.readLine()) != null) {
            System.out.println(read);
        }

        Assertions.assertThat(output()).contains(exp, result, description);
    }
}
