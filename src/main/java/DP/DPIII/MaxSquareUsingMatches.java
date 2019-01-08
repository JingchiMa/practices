package DP.DPIII;

class Point {
    boolean right;
    boolean down;

    Point(boolean right, boolean down) {
        this.right = right;
        this.down = down;
    }
}

public class MaxSquareUsingMatches {

    int maxSquare(Point[][] input) {
        int[][] right = right(input);
        int[][] down = down(input);

        int m = input.length;
        int n = input[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = Math.min(m - 1 - i, n - 1 - j); l >= 0; l--) {
                    // i, j        i, j + l
                    // i + l, j    i + l, j + l
                    if (right[i][j] >= l + 1 && down[i][j] >= l + 1
                            && right[i + l][j] >= l + 1 && down[i][j + l] >= l + 1) {
                        max = Math.max(max, l);
                    }
                }
            }
        }
        return max;
    }

    private int[][] right(Point[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (!input[i][j].right) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 1;
                    if (j + 1 < n) {
                        res[i][j] += res[i][j + 1];
                    }
                }
            }
        }
        return res;
    }

    private int[][] down(Point[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (!input[i][j].down) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = 1;
                    if (i + 1 < m) {
                        res[i][j] += res[i + 1][j];
                    }
                }
            }
        }
        return res;
    }
}
