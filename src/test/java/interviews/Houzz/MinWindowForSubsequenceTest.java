package interviews.Houzz;

import org.junit.Test;
import strengthenV.MinDistanceSum;

import static org.junit.Assert.*;

public class MinWindowForSubsequenceTest {
    @Test
    public void minWindow() throws Exception {
        MinWindowForSubsequence instance = new MinWindowForSubsequence();
        System.out.println(instance.minWindow("cnhczmccqouqadqtmjjzl"
                ,"cm"));
    }

    @Test
    public void minimumSubstring() throws Exception {
        MinWindowForSubsequence instance = new MinWindowForSubsequence();
        System.out.println(instance.minimumSubstring("cnhczmccqouqadqtmjjzl","cm"));
    }

    @Test
    public void minWindowIITest() throws Exception {
        MinWindowForSubsequence instance = new MinWindowForSubsequence();
        System.out.println(instance.minWindowII("cnhczmccqouqadqtmjjzl","cm"));
    }


}