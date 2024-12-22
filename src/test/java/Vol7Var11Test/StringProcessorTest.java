package Vol7Var11Test;

import Vol7Var11.StringProcessor;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {
    @Test
    public void testProcessString_withinLimits() {
        String result = StringProcessor.processString("Hello world test case", 2, 3, 50);
        assertEquals("Hello,world,test,Hello,world,test,", result);
    }

    @Test
    public void testProcessString_exceedsWordLimit() {
        String result = StringProcessor.processString("One two three four five", 1, 3, 50);
        assertEquals("One,two,three,", result);
    }

    @Test
    public void testProcessString_exceedsLengthLimit() {
        String result = StringProcessor.processString("Alpha Beta Gamma Delta", 3, 4, 20);
        assertEquals("Alpha,Beta,Gamma,Del", result); // Только первые 20 символов
    }

    @Test
    public void testProcessString_noWordsLimit() {
        String result = StringProcessor.processString("Java is fun", 1, 10, 50);
        assertEquals("Java,is,fun,", result);
    }
}
