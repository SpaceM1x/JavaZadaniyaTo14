package Vol8Var11Test;

import Vol8Var11.SubstringProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringProcessorTest {
    @Test
    public void testRemoveLongestSubstring_withValidSubstring() {
        Assertions.assertEquals("Hello  world", SubstringProcessor.removeLongestSubstring("Hello <this is a test> world", '<', '>'));
    }

    @Test
    public void testRemoveLongestSubstring_noMatchingSubstring() {
        assertEquals("No brackets here", SubstringProcessor.removeLongestSubstring("No brackets here", '<', '>'));
    }

    @Test
    public void testRemoveLongestSubstring_startAfterEnd() {
        assertEquals("Invalid order", SubstringProcessor.removeLongestSubstring("Invalid order", '>', '<'));
    }
}
