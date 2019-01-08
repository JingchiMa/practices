package DP.DPIII;

public class SquareSurroundedByOne {

    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] down = down(matrix);
        int[][] right = right(matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = Math.min(m - 1 - i, n - 1 - j); l >= 0; l--) {
          /*
          (i, j)    (i, j + l)
          (i + l, j)  (i + l, j + l)
          */
                    if (down[i][j] >= l + 1 && right[i][j] >= l + 1
                            && down[i][j + l] >= l + 1 && right[i + l][j] >= l + 1) {
                        max = Math.max(max, l + 1);
                    }
                }
            }
        }
        return max;
    }

    private int[][] down(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
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

    private int[][] right(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
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


}

