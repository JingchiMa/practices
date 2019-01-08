package leetcodes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WordLadderTest {
    @Test
    public void ladderLength() throws Exception {
        WordLadder instance = new WordLadder();
        System.out.println(instance.ladderLength("cbt", "acd", new ArrayList<>(Arrays.asList("cat", "cac", "cbc", "ccc", "ccd", "acd"))));
    }

}