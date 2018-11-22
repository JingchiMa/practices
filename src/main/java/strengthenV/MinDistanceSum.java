package strengthenV;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDistanceSum {
    private final static char obstacle = 'o';
    private final static char equipment = 'e';
    private static final int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    // assumption: board is rectangle

    public int[] bestLocation(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == equipment) {
                    updateDistances(i, j, board, distances);
                }
            }
        }
        // find the minimum one
        return minDistanceLocation(distances);
    }

    private void updateDistances(int i, int j, char[][] board, int[][] distances) {
        boolean[][] visited = new boolean[distances.length][distances[0].length];
        // run bfs from i and j
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                // need to check if the index is an equipment
                if (board[cur[0]][cur[1]] != equipment) {
                    distances[cur[0]][cur[1]] += distance;
                }
                for (int[] delta : deltas) {
                    int newRow = cur[0] + delta[0]; // cur instead of i or j!!!!
                    int newCol = cur[1] + delta[1];
                    if (isValid(newRow, newCol, board, visited)) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            distance++;
        }
    }

    private boolean isValid(int row, int col, char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        return obstacle != board[row][col]; // let's assume we can go through equipments
    }

    private int[] minDistanceLocation(int[][] distances) {
        int min = Integer.MAX_VALUE;
        int row = -1;
        int col = -1;
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                if (distances[i][j] == 0) { // wrong. because this location may not be accessible
                    // for all nodes (which is not valid), but still have non zero distance.
                    /*
                    上面的评论是错误的！只存在两种情况:
                    1. 存在两个equipment，他们两个不连通，这样不存在任何一个点，能够联通所有的椅子
                    2. 所有的equipment都是联通的，那么并不存在这样的一个点，只与某几个equipment联通
                     */
                    continue;
                }
                if (min > distances[i][j]) {
                    min = distances[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new int[] {row, col};
    }
}
