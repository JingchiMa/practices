package interviews.AppDynamics;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringTest {
    @Test
    public void maxSubstringWithKUnique() throws Exception {
        LongestSubstring instance = new LongestSubstring();
        System.out.println(instance.maxSubstringWithKUnique("abeeouio", 3));
    }



    @Test
    public void maxStringWithKDistinct() throws Exception {
        LongestSubstring instance = new LongestSubstring();
        System.out.println(instance.maxStringWithKDistinct("abeeouio", 3));
    }

}