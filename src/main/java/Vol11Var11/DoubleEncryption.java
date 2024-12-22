package Vol11Var11;

import java.util.stream.IntStream;

public class DoubleEncryption {
    public static int[] findKeys(String original, String encrypted) {
        int[] keys = new int[2];

        IntStream.range(0, 1 << 20).parallel().forEach(k1 -> {
            String intermediate = encrypt(original, k1);
            IntStream.range(0, 1 << 20).parallel().forEach(k2 -> {
                if (encrypt(intermediate, k2).equals(encrypted)) {
                    keys[0] = k1;
                    keys[1] = k2;
                }
            });
        });

        return keys;
    }

    public static String encrypt(String input, int key) {

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((char) (c ^ key));
        }
        return sb.toString();
    }
}
