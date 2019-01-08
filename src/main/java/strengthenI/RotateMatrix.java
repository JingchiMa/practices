package strengthenI;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        rotate(matrix, matrix.length);
    }

    private void rotate(int[][] matrix, int len) {
        if (len <= 1) {
            return;
        }
        int start = (matrix.length - len) / 2;
        int end = start + len - 1;
        for (int col = start; col < end; col++) {
            int tmp = matrix[start][col];
            matrix[start][col] = matrix[end - col][start];
            matrix[end - col][start] = matrix[end][end - col];
            matrix[end][end - col] = matrix[col][end];
            matrix[col][end] = tmp;
        }
        rotate(matrix, len - 2);
    }

}
