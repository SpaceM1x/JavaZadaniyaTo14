package Vol7Var11;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.BiFunction;

public class StringProcessor {
    public static String processString(String input, int n, int m, int l) {

        BiFunction<String, Integer, String> process = (str, limit) -> Arrays.stream(str.split(" "))
                .limit(limit)
                .map(word -> word + ",")
                .collect(Collectors.joining());

        String repeatedString = process.apply(input, m).repeat(n);
        return repeatedString.length() > l ? repeatedString.substring(0, l) : repeatedString;
    }
}
