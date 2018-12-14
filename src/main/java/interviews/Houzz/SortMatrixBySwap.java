package interviews.Houzz;

import java.util.*;

public class SortMatrixBySwap {
    private static final int[][] deltas = {{1,0}, {0,1}, {0,-1}, {-1,0}};

    List<int[]> printPath(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<List<int[]>> swapPath = new ArrayList<>();
        dfs(board, m-1, n-1, new boolean[m][n], new ArrayList<>(), swapPath);
        return swapPath.isEmpty() ? new ArrayList<>() : swapPath.get(0);
    }

    private void dfs(int[][] board, int row, int col, boolean[][] visited, List<int[]> path, List<List<int[]>> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (isSorted(board)) {
            result.add(new ArrayList<>(path));
            return;
        }
        List<int[]> nextPositions = getNextPositions(row, col, visited);
        for (int[] next: nextPositions) {
            visited[next[0]][next[1]] = true;
            path.add(next);
            swap(board, row, col, next[0], next[1]);
            dfs(board, next[0], next[1], visited, path, result);
            swap(board, row, col, next[0], next[1]);
            path.remove(path.size() - 1);
            visited[next[0]][next[1]] = false;
        }
    }

    private List<int[]> getNextPositions(int row, int col, boolean[][] visited) {
        List<int[]> results = new ArrayList<>();
        for (int[] delta : deltas) {
            int newRow = row + delta[0];
            int newCol = col + delta[1];
            if (newRow >= 0 && newRow < visited.length && newCol >= 0 && newCol < visited[0].length && !visited[newRow][newCol]) {
                results.add(new int[] {newRow, newCol});
            }
        }
        return results;
    }

    private boolean isSorted(int[][] matrix) {
        int correctNum = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != correctNum) {
                    return false;
                }
                correctNum++;
            }
        }
        return true;
    }

    private void swap(int[][] board, int oldRow, int oldCol, int newRow, int newCol) {
        int tmp = board[oldRow][oldCol];
        board[oldRow][oldCol] = board[newRow][newCol];
        board[newRow][newCol] = tmp;
    }
}
