package DP.DPII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EditDistance {

    public List<String> minDistance(String src, String dst) {
        int m = src.length();
        int n = dst.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (src.charAt(i - 1) == dst.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min( Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j] ) + 1;
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder(dst);
        List<String> results = new ArrayList<>();
        results.add(dst);
        while (i > 0 || j > 0) {
            if (src.charAt(i - 1) == dst.charAt(j - 1)) {
                i--;
                j--;
            } else {
                if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                    sb.insert(j, src.charAt(i - 1));
                    i--;
                } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                    sb.deleteCharAt(j - 1);
                    j--;
                } else {
                    sb.setCharAt(j - 1, src.charAt(i - 1));
                    i--;
                    j--;
                }
                results.add(sb.toString());
            }
        }
        Collections.reverse(results);
        return results;
    }
}
