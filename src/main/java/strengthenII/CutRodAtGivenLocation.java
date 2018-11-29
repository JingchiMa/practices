package strengthenII;

public class CutRodAtGivenLocation {

    public int minCost(int length, int[] cuttingIndices) {

        // 0, indices in cutting indices, length

        int[] indices = getIndices(cuttingIndices, length);
        int[][] dp = new int[indices.length][indices.length];
        // [left, right)
        // [indices[i-1], indices[i])
//        for (int i = 1; i < indices.length; i++) {
//            dp[i-1][i] = indices[i] - indices[i-1];
//        }
        // dp[i][j] = min { dp[i][k] + dp[k][j] + j - i } over i < k < j

        /*
        0  1  2  3  4
           C     C
        indices = [0, 1, 3, 5]
                   0  1  2  3
        length = 5, cutting indices = 1 and 3
        i\j  0  1  2  3
        0       1
        1          2
        2             2
        3
        */
        for (int i = indices.length - 2; i >= 0; i--) {
            for (int j = i + 2; j < indices.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + indices[j] - indices[i]);
                }
            }
        }
        return dp[0][indices.length-1];
    }

    private int[] getIndices(int[] indices, int length) {
        int[] res = new int[indices.length  + 2];
        System.arraycopy(indices, 0, res, 1, indices.length);
        res[0] = 0;
        res[res.length - 1] = length;
        return res;
    }
}
