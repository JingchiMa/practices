package strengthenII;

public class MergeStones {
    public int minCost(int[] weights) {
        int[] prefixSums = new int[weights.length + 1];
        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + weights[i-1];
        }
        int[][] dp = new int[weights.length][weights.length];
        // initial states:
        for (int i = 0; i < weights.length - 1; i++) {
            dp[i][i+1] = weights[i] + weights[i+1];
        }
        for (int i = weights.length - 1; i >= 0; i--) {
            for (int j = i + 2; j < weights.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // [0, j]
                    // [0, i-1]
                    // [i, j]
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + prefixSums[j + 1] - prefixSums[i]);
                }
            }
        }
        return dp[0][weights.length - 1];
    }

}
