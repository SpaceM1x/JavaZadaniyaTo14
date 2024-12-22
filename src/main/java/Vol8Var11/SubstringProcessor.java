package Vol8Var11;

public class SubstringProcessor {
    public static String removeLongestSubstring(String sentence, char start, char end) {
        int startIndex = sentence.indexOf(start);
        int endIndex = sentence.lastIndexOf(end);

        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            return sentence.substring(0, startIndex) + sentence.substring(endIndex + 1);
        }

        return sentence;
    }
}
