package strengthenI;

import org.junit.Test;

import static org.junit.Assert.*;

public class RainbowSortTest {
    @Test
    public void sortColors2() throws Exception {
        RainbowSort instance = new RainbowSort();
        int[] nums = {1,1,2,2,2};
        int k = 2;
        instance.sortColors2(nums, k);
    }

}