package interviews.Houzz;

public class NumMatrix {

    private final int[][] prefixSum;

    /*
    1 1 1
    1 1 1
    1 1 1

    0 0 0 0
    0 1 2 3
    0 2 4 6
    0 3 6 9


    */

    public NumMatrix(int[][] matrix) {
        // prefixSum[i][j] = sum [0,0] -> [i,j]
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];
        // matrix (i-1,j-1) -> prefixSum (i, j)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        /*
        row1 - 1, col1 - 1

                row1, col1      row1, col2



                row2, col1      row2, col2
        */
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row2 + 1][col1]
                - prefixSum[row1][col2 + 1] + prefixSum[row1][col1];
    }

}
