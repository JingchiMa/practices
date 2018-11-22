package midtermReview;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberArrangementsTest {
    @Test
    public void arrangement() throws Exception {
        NumberArrangements instance = new NumberArrangements();
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println(instance.arrangement(nums));
        System.out.println(instance.numArrange(nums));
    }

}