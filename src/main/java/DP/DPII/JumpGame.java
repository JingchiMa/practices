package DP.DPII;

import java.util.Arrays;

public class JumpGame {
    int minSteps(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < array.length; i++) {
            dp[i] = -1;
            for (int j = 1; j <= Math.min(i, array[i]); j++) {
                if (dp[i] == -1 || dp[i] > dp[i - j] + 1) {
                    dp[i] = dp[i - j] + 1;
                }
            }
        }
        return dp[array.length - 1];
    }

}
