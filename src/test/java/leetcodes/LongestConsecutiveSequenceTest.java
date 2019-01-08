package leetcodes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsecutiveSequenceTest {
    @Test
    public void longestConsecutive() throws Exception {
        LongestConsecutiveSequence instance = new LongestConsecutiveSequence();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        instance.longestConsecutive(nums);
    }

}