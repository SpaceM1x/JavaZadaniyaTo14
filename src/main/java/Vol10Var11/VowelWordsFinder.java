package Vol10Var11;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class VowelWordsFinder {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');

    public static List<String> findVowelWords(List<String> lines) {
        return lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> !word.isEmpty() && VOWELS.contains(word.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void processFile(String inputFile, String outputFile) throws IOException {
        List<String> lines = readLinesFromFile(inputFile);
        List<String> vowelWords = findVowelWords(lines);
        writeLinesToFile(outputFile, vowelWords);
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().collect(Collectors.toList());
        }
    }

    private static void writeLinesToFile(String filePath, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
