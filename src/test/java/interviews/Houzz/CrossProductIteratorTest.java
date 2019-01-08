package interviews.Houzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CrossProductIteratorTest {
    @Test
    public void hasNext() throws Exception {
        List<List<Character>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        input.add(new ArrayList<>(Arrays.asList('f', 'g')));
        input.add(new ArrayList<>(Arrays.asList('h', 'i', 'j')));
        CrossProductIterator iterator = new CrossProductIterator(input);
        assertTrue(iterator.hasNext());
    }

    @Test
    public void next() throws Exception {
        List<List<Character>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        input.add(new ArrayList<>(Arrays.asList('f', 'g')));
        input.add(new ArrayList<>(Arrays.asList('h', 'i', 'j')));
        CrossProductIterator iterator = new CrossProductIterator(input);

        List<String> expected = new ArrayList<>(Arrays.asList("afh", "afi", "afj", "agh", "agi", "agj", "bfh", "bfi", "bfj",
                "bgh", "bgi", "bgj", "cfh", "cfi", "cfj", "cgh", "cgi", "cgj"));
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected.get(i), iterator.next());
            i++;
        }
        assertTrue(i == expected.size());
        assertTrue(!iterator.hasNext());
    }

}