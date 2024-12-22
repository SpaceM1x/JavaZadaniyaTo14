package Vol10Var11Test;

import Vol10Var11.LastWordsExtractor;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LastWordsExtractorTest {
    @Test
    public void testExtractLastWords() throws IOException {
        String inputFile = "input.txt";
        String outputDir = "output";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("First line\nSecond line with words\nThird line also has words\n");
        }

        LastWordsExtractor.extractLastWords(inputFile, outputDir, 2, 2);

        try (BufferedReader reader = new BufferedReader(new FileReader(outputDir + "/result.txt"))) {
            List<String> output = reader.lines().toList();
            assertEquals(List.of("with", "words", "has", "words"), output);
        } finally {
            new File(inputFile).delete();
            new File(outputDir).deleteOnExit();
        }
    }
}
