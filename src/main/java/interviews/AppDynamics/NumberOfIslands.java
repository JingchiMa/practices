package interviews.AppDynamics;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    private static final int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /*
    start point: (row, col)
    expansion/generation rule:
        each time expand a node, generate all its unvisited neighbors
    */

    private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] delta : deltas) {
                int nextRow = cur[0] + delta[0];
                int nextCol = cur[1] + delta[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length) {
                    if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[] {nextRow, nextCol});
                    }
                }
            }
        }
    }
}
