package interviews.AppDynamics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {
    @Test
    public void wordBreakTest1() throws Exception {
        WordBreak instance = new WordBreak(new String[] {"ab", "cd", "e"});
        System.out.println(instance.wordBreak("abcde"));
    }

    @Test
    public void wordBreakTest2() throws Exception {
        WordBreak instance = new WordBreak(new String[] {"abc", "ab", "de", "e"});
        List<String> expected = new ArrayList<>(Arrays.asList("abc", "de"));
        assertEquals(expected, instance.wordBreak("abcde"));
    }

    @Test
    public void wordBreakTest3() throws Exception {
        WordBreak instance = new WordBreak(new String[] {"abc", "ab", "e"});
        List<String> expected = new ArrayList<>();
        assertEquals(expected, instance.wordBreak("abcde"));
    }

}