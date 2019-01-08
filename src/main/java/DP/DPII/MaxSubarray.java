package DP.DPII;

public class MaxSubarray {

    int[] maxSubarray(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int dp = nums[0];
        int left = 0;
        int globalLeft = 0;
        int globalRight = 0;
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
                left = i;
            }
            if (dp > max) {
                max = dp;
                globalLeft = left;
                globalRight = i;
            }
        }
        return new int[] {globalLeft, globalRight};
    }

}
