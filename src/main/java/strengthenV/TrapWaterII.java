package strengthenV;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapWaterII {
    static class Point {
        int row;
        int col;
        int height;

        public Point(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    private static final int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        if (m == 0) {
            return 0;
        }
        int n = heights[0].length;
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.height - p2.height;
            }
        });
        int sum = 0;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            pq.offer(new Point(0, j, heights[0][j]));
        }
        for (int i = 1; i < m; i++) {
            visited[i][n-1] = true;
            pq.offer(new Point(i, n-1, heights[i][n-1]));
        }
        for (int j = n-2; j >= 0; j--) {
            visited[m-1][j] = true;
            pq.offer(new Point(m-1, j, heights[m-1][j]));
        }
        for (int i = m - 2; i >= 1; i--) {
            visited[i][0] = true;
            pq.offer(new Point(i, 0, heights[i][0]));
        }
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (int[] delta : deltas) {
                int newRow = cur.row + delta[0];
                int newCol = cur.col + delta[1];
                if (newRow >= 0 && newRow < m && newCol >=0 && newCol < n && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    sum += Math.max(0, cur.height - heights[newRow][newCol]);
                    pq.offer( new Point(newRow, newCol, Math.max( cur.height, heights[newRow][newCol] ) ) );
                }
            }
        }
        return sum;
    }
}
