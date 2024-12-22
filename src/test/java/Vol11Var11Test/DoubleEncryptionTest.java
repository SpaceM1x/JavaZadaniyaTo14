package Vol11Var11Test;

import Vol11Var11.DoubleEncryption;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleEncryptionTest {
    @Test
    public void testFindKeys() {
        String original = "Hello, World!";
        int key1 = 12345;
        int key2 = 67890;

        String encrypted = DoubleEncryption.encrypt(DoubleEncryption.encrypt(original, key1), key2);

        int[] keys = DoubleEncryption.findKeys(original, encrypted);
        assertEquals(key1, keys[0]);
        assertEquals(key2, keys[1]);
    }

    @Test
    public void testEncrypt() {
        String original = "Test";
        int key = 12345;

        String encrypted = DoubleEncryption.encrypt(original, key);
        String decrypted = DoubleEncryption.encrypt(encrypted, key);

        assertEquals(original, decrypted);
    }
}
