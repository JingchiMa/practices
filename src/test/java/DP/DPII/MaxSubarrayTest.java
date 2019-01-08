package DP.DPII;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubarrayTest {
    @Test
    public void maxSubarray() throws Exception {
        MaxSubarray instance = new MaxSubarray();
        int[] nums = {1, 2, 4, -1, -2, 10, -1};
        int[] expected = {0, 5};
        assertArrayEquals(expected, instance.maxSubarray(nums));
    }

}