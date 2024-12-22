package Vol8Var11;

import java.util.Map;

public class HyphenationProcessor {
    private static final Map<String, String> SYLLABLES = Map.of(
            "example", "ex-am-ple",
            "programming", "pro-gram-ming",
            "test", "test"
    );

    public static String hyphenateWord(String word) {
        return SYLLABLES.getOrDefault(word.toLowerCase(), word);
    }

    public static String hyphenateText(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(hyphenateWord(word)).append(" ");
        }

        return result.toString().trim();
    }
}
