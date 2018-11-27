package quora;

import java.util.Arrays;

public class MaxSubsequenceNum {

    public int maxSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] != nums[i] - 1) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
