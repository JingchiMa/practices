package quora;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MaxSubsequenceNumTest {
    @Test
    public void maxSum() throws Exception {
        MaxSubsequenceNum instance = new MaxSubsequenceNum();
        int[] nums = {1, 2, 3, 3, 5, 6};
        assertEquals(13, instance.maxSum(nums));
    }

    @Test
    public void maxSumTest2() throws Exception {
        MaxSubsequenceNum instance = new MaxSubsequenceNum();
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4};
        assertEquals(22, instance.maxSum(nums));
    }

    @Test
    public void maxSumTest3() throws Exception {
        MaxSubsequenceNum instance = new MaxSubsequenceNum();
        int[] nums = {1,1,1,1,2,2,2,2,3,4,4,5,5,5};
        assertEquals(23, instance.maxSum(nums));
    }

    @Test
    public void maxSumTest4() throws Exception {
        MaxSubsequenceNum instance = new MaxSubsequenceNum();
        int[] nums = {1,1,1,1,2,2,2,2,3,4,4,5,5,5};
        shuffle(nums);
        assertEquals(23, instance.maxSum(nums));
    }

    private void shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = (int) (Math.random() * (nums.length - i) + i);
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }


}