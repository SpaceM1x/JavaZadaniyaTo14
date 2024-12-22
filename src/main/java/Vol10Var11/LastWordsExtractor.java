package Vol10Var11;

import java.io.*;
import java.util.*;

public class LastWordsExtractor {
    public static void extractLastWords(String inputFile, String outputDir, int n, int m) throws IOException {
        List<String> lines = readLinesFromFile(inputFile);

        List<String> lastLines = lines.subList(Math.max(lines.size() - n, 0), lines.size());
        List<String> result = new ArrayList<>();

        for (String line : lastLines) {
            String[] words = line.split("\\s+");
            result.addAll(Arrays.asList(words).subList(Math.max(words.length - m, 0), words.length));
        }

        File dir = new File(outputDir);
        if (!dir.exists()) dir.mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir, "result.txt")))) {
            for (String word : result) {
                writer.write(word);
                writer.newLine();
            }
        }
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().toList();
        }
    }
}
