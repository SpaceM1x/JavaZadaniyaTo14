package Vol10Var11Test;

import Vol10Var11.VowelWordsFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class VowelWordsFinderTest {
    @Test
    public void testFindVowelWords() {
        List<String> input = List.of("Apple is tasty", "Umbrella and orange");
        List<String> expected = List.of("Apple", "is", "Umbrella", "and", "orange");
        Assertions.assertEquals(expected, VowelWordsFinder.findVowelWords(input));
    }

    @Test
    public void testProcessFile() throws IOException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Apple is tasty\nUmbrella and orange");
        }

        VowelWordsFinder.processFile(inputFile, outputFile);

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            List<String> output = reader.lines().collect(Collectors.toList());
            assertEquals(List.of("Apple", "is", "Umbrella", "and", "orange"), output);
        } finally {
            new File(inputFile).delete();
            new File(outputFile).delete();
        }
    }
}
