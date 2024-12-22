package Vol9Var11Test;

import Vol9Var11.InvalidNumberException;
import Vol9Var11.NumberProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.List;

public class NumberProcessorTest {
    private final String testFilePath = "test_numbers.txt";

    private void createTestFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write(content);
        }
    }

    @Test
    public void testReadNumbersFromFile_validData() throws Exception {
        createTestFile("123.45,en-US\n678.90,fr-FR\n-56.78,en-GB");
        List<Double> numbers = NumberProcessor.readNumbersFromFile(testFilePath);
        assertEquals(3, numbers.size());
        assertTrue(numbers.contains(123.45));
        assertTrue(numbers.contains(678.90));
        assertTrue(numbers.contains(-56.78));
    }

    @Test
    public void testReadNumbersFromFile_invalidNumberFormat() {
        assertThrows(InvalidNumberException.class, () -> {
            createTestFile("123.45,en-US\ninvalidNumber,fr-FR");
            NumberProcessor.readNumbersFromFile(testFilePath);
        });
    }

    @Test
    public void testReadNumbersFromFile_outOfRangeNumber() {
        assertThrows(InvalidNumberException.class, () -> {
            createTestFile("1.7E309,en-US"); // Number too large
            NumberProcessor.readNumbersFromFile(testFilePath);
        });
    }

    @Test
    public void testReadNumbersFromFile_missingFile() {
        assertThrows(RuntimeException.class, () -> {
            NumberProcessor.readNumbersFromFile("non_existing_file.txt");
        });
    }

    @Test
    public void testCalculateSumAndAverage() throws Exception {
        createTestFile("123.45,en-US\n678.90,fr-FR\n-56.78,en-GB");
        List<Double> numbers = NumberProcessor.readNumbersFromFile(testFilePath);

        double sum = NumberProcessor.calculateSum(numbers);
        double average = NumberProcessor.calculateAverage(numbers);

        assertEquals(745.57, sum, 0.01);
        assertEquals(248.52, average, 0.01);
    }
}
