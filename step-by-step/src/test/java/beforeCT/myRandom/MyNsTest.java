package beforeCT.myRandom;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class MyNsTest {
    private PrintStream standardOut;
    private OutputStream captor;

    public static Random random = new Random();

    public MyNsTest() {
    }

    @BeforeEach
    protected final void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void init() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return captor.toString().trim(); // trim() 공백 제거를 하기 위함
    }

    protected final void command(String... args) {
        byte[] getBytes = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(getBytes));

    }

}



