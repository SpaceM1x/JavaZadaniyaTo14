package Vol8Var11Test;

import Vol8Var11.HyphenationProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HyphenationProcessorTest {
    @Test
    public void testHyphenateWord_withKnownWord() {
        Assertions.assertEquals("ex-am-ple", HyphenationProcessor.hyphenateWord("example"));
    }

    @Test
    public void testHyphenateWord_withUnknownWord() {
        assertEquals("unknown", HyphenationProcessor.hyphenateWord("unknown"));
    }

    @Test
    public void testHyphenateText() {
        String result = HyphenationProcessor.hyphenateText("This is an example programming test");
        assertEquals("This is an ex-am-ple pro-gram-ming test", result);
    }
}
