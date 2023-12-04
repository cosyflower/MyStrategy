package beforeCT.remind;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CommonTemplateAboutIO {
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    private final PrintStream standardOutput = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captor));
    }

    protected InputStream convertInputToInputStream(String userInput) {
        byte[] bytes = userInput.getBytes();
        return new ByteArrayInputStream(bytes);
    }

    protected SequenceInputStream convertMultipleInputsToInputStream(String... userInputs) {
        List<InputStream> inputStreamList = new ArrayList<>();
        for (String input : userInputs) {
            inputStreamList.add(convertInputToInputStream(input));
        }
        return new SequenceInputStream(Collections.enumeration(inputStreamList));
    }

    protected void setInGeneratedInputStream(InputStream generatedInputStream) {
        System.setIn(generatedInputStream);
    }

    protected String output() {
        return captor.toString().trim();
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOutput);
        System.out.println("afterEach() called" + output());
        captor.reset();
    }
}
