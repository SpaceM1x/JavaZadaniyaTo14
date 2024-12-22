package Vol11Var11Test;

import Vol11Var11.ListReorganizer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListReorganizerTest {
    @Test
    public void testReorganize() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -2, 3, -4, 5, -6));
        List<Integer> expected = Arrays.asList(1, 3, 5, -4, -2, -6);

        ListReorganizer.reorganize(input);
        assertEquals(expected, input);
    }

    @Test
    public void testAllPositive() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        ListReorganizer.reorganize(input);
        assertEquals(expected, input);
    }

    @Test
    public void testAllNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5));
        List<Integer> expected = Arrays.asList(-1, -2, -3, -4, -5);

        ListReorganizer.reorganize(input);
        assertEquals(expected, input);
    }
}
