package Vol11Var11Test;

import Vol11Var11.DoubleEncryption;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleEncryptionTest {

    @Test
    public void testFindKeys() {
        String original = "HELLO WORLD";
        String encrypted = "KHOOR ZRUOG";

        int[] keys = DoubleEncryption.findKeys(original, encrypted);

        assertEquals("Key1 should match", keys[0], keys[0]);
        assertEquals("Key2 should match", keys[1], keys[1]);
    }

    @Test
    public void testEncrypt() {
        String input = "HELLO";
        int key = 3;

        String expected = "KHOOR";
        String actual = DoubleEncryption.encrypt(input, key);

        assertEquals("Encryption result should match", expected, actual);
    }

    @Test
    public void testNoKeysFound() {
        String original = "HELLO";
        String encrypted = "WORLD";

        int[] keys = DoubleEncryption.findKeys(original, encrypted);

        assertEquals("Key1 should be 0 when no match found", 0, keys[0]);
        assertEquals("Key2 should be 0 when no match found", 0, keys[1]);
    }
}
