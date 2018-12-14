package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourSumTest {
    @Test
    public void fourSumNums() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {1, 3, 10, 7, 6, 2, 3, 3, 2, 0};   // 1 3 3 3, 7 2 1 0, 6 2 2 0
        int target = 10;
        System.out.println(instance.fourSumNums(nums, target));
    }

}