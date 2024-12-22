package Vol8Var11;

import java.util.HashSet;
import java.util.Set;

public class TextProcessor {
    private static final Set<Character> VOWELS = new HashSet<>(
            Set.of('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
    );

    public static String analyzeSentence(String sentence) {
        long vowelsCount = sentence.chars()
                .filter(c -> VOWELS.contains((char) c))
                .count();
        long consonantsCount = sentence.chars()
                .filter(c -> Character.isLetter(c) && !VOWELS.contains((char) c))
                .count();

        return vowelsCount > consonantsCount
                ? "More vowels"
                : (consonantsCount > vowelsCount ? "More consonants" : "Equal vowels and consonants");
    }
}
