package strengthenVII;

public class RandomMaze {
    private static final int[][] deltas = {{2, 0}, {0, 2}, {0, -2}, {-2, 0}};

    public int[][] generateRandomMaze(int n) {
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = 1;
            }
        }
        maze[0][0] = 0;
        dfs(maze, 0, 0);
        return maze;
    }

    private void dfs(int[][] maze, int row, int col) {
        int[][] randomDeltas = shuffle(deltas);
        for (int[] delta : randomDeltas) {
            int newRow = row + delta[0];
            int newCol = col + delta[1];
            if (isValidWall(maze, newRow, newCol)) {
                maze[row + delta[0] / 2][col + delta[1] / 2] = 0;
                maze[newRow][newCol] = 0;
                dfs(maze, newRow, newCol);
            }
        }
    }

    private boolean isValidWall(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 1;
    }

    private int[][] shuffle(int[][] deltas) {
        int[][] newDeltas = new int[deltas.length][deltas[0].length];
        for (int i = 0; i < deltas.length; i++) {
            for (int j = 0; j < deltas[0].length; j++) {
                newDeltas[i][j] = deltas[i][j];
            }
        }
        for (int i = 0; i < newDeltas.length; i++) {
            int index = (int) (Math.random() * (newDeltas.length - i) + i);
            int[] tmp = newDeltas[i];
            newDeltas[i] = newDeltas[index];
            newDeltas[index] = tmp;
        }
        return newDeltas;
    }

}
