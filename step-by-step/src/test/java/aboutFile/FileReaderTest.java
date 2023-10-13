package aboutFile;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileReaderTest {
    @Test
    void read_file() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/test/java/aboutFile/names.md"));

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }

    @Test
    void write_file() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./namesB.txt"));

        bufferedWriter.write("ABC\n");
        bufferedWriter.write("DEF\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }


}
