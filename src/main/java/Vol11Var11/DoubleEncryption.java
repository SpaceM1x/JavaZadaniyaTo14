package Vol11Var11;

import java.util.stream.IntStream;

public class DoubleEncryption {
    public static int[] findKeys(String original, String encrypted) {
        int[] keys = new int[2];
        boolean[] found = new boolean[1];

        IntStream.range(0, 1 << 10).parallel().forEach(k1 -> {
            if (found[0]) return;
            String intermediate = encrypt(original, k1);
            IntStream.range(0, 1 << 10).forEach(k2 -> {
                if (encrypt(intermediate, k2).equals(encrypted)) {
                    synchronized (keys) {
                        if (!found[0]) {
                            keys[0] = k1;
                            keys[1] = k2;
                            found[0] = true;
                        }
                    }
                }
            });
        });

        return keys;
    }

    public static String encrypt(String input, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                sb.append((char) ((c - base + key) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
