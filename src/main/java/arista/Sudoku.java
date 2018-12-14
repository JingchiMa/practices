package arista;

public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        //originalGrid = grid;
        solveSudoku(grid);
        System.out.println("Done!");
        printGrid(grid);
    }

    public static boolean solveSudoku(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                for (int num = 1; num <= 9; num++) {
                    if (noConflict(grid)) {
                        grid[i][j] = num;
                        if (solveSudoku(grid)) {
                            return true;
                        } else {
                            grid[i][j] = 0;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    /**
     * Checks row, column and box have unique values.
     *
     * @param grid
     * @return
     */
    public static boolean noConflict(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //int current = grid[i][j];

                // check row unique
                for (int k = 0; k < 9; k++) {
                    if (grid[i][j] == grid[k][j] && k != i && grid[i][j] != 0
                            && grid[k][j] != 0) {
                        return false;
                    }
                }

                //check column unique
                for (int k = 0; k < 9; k++) {
                    if (grid[i][j] == grid[i][k] && k != j && grid[i][j] != 0
                            && grid[i][k] != 0) {
                        return false;
                    }
                }

                // check block
                for (int row = (i/3)*3; row < (i/3)*3+3; row++) {
                    for (int col = (j/3)*3; col < (j/3)*3+3; col++) {
                        if(row != i && col!=j && grid[row][col]==grid[i][j] && grid[i][j] != 0) {
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    public static boolean noUnassignedLocation(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printGrid(int[][] grid) {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            String line = new String();
            for (int j = 0; j < 9; j++) {
                line = line + grid[i][j];
            }
            System.out.println(line);
        }
        System.out.println();
    }
}
