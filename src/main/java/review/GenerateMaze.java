package review;

public class GenerateMaze {


    private static final int[][] deltas = {{2,0}, {0,2}, {-2,0},{0,-2}};

    public int[][] maze(int n) {
        // Write your solution here.
        /*
        O O O X
        X X O X
        O O O X
        X X X X
        exactly one path => no cycle
        has to use dfs to generate corridor, not wall because corridors have to be connected
        corridor width = 1 => dfs step >= 2
        wall width = 1 => dfs step <= 2
        */

        // step1 : fill the matrix with 1's
        int[][] maze = new int[n][n];
        for (int[] row : maze) {
            for (int i = 0; i < row.length; i++) {
                row[i] = 1;
            }
        }
        // don't forget to set (0, 0) to be 0
        maze[0][0] = 0;
        // step 2: dfs
        dfs(maze, 0, 0);
        return maze;
    }

    /*
    level: a cell
    each level has 4 choices: up, down, left, right.
    valid location is defined as value = 1
    */
    private void dfs(int[][] matrix, int row, int col) {
        matrix[row][col] = 0;
        shuffle(deltas);
        for (int[] delta : deltas) {
            int newRow = delta[0] + row;
            int newCol = delta[1] + col;
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                if (matrix[newRow][newCol] == 1) {
                    matrix[row + delta[0] / 2][col + delta[1] / 2] = 0; // 是把path设成0！！！不仅仅是一个点
                    matrix[newRow][newCol] = 0;
                    dfs(matrix, newRow, newCol);
                }
            }
        }
    }

    private void shuffle(int[][] deltas) {
        for (int i = 0; i < deltas.length; i++) {
            int j = (int) (Math.random() * (deltas.length - i) + i);
            swap(deltas, i, j);
        }
    }

    private void swap(int[][] deltas, int i, int j) {
        int[] tmp = deltas[i];
        deltas[i] = deltas[j];
        deltas[j] = tmp;
    }

}
