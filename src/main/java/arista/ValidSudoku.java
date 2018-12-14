package arista;

import java.util.HashSet;
import java.util.Set;

import static utils.Display.display;

public class ValidSudoku {
    /*
    generate a valid 3*3 grid
    call generateSudoku at the end of each recursion

    two functions:
    1. generateSudoku
        9 levels in total, each level represents a 3*3 grid
    2. generate 3*3 grid, each level represents the possible location for number i
     */

    private final int length;
    private final int subLength;
    private final int[] nums;

    public ValidSudoku(int length, int subLength) {
        this.length = length;
        this.subLength = subLength;
        this.nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = i + 1;
        }
    }

    public void generateSudoku(int[][] matrix) {
        int[][] result = new int[length][length];
        generateSudoku(matrix, 0, result);
        display(result);
    }

    private void generateSudoku(int[][] matrix, int level, int[][] result) {
        if (level >= length) {
            copyResult(matrix, result);
            display(result);
            System.exit(1);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int row = level / subLength; row < level / subLength + subLength; row++) {
            for (int col = level % subLength; col < level % subLength; col++) {
                set.add(matrix[row][col]);
            }
        }
        generateSub(matrix, 0, level, result, set);
    }

    // location is defined as the 1-D representation of the matrix
    private void generateSub(int[][] matrix, int location, int level, int[][] result, Set<Integer> set) {
        if (location >= length) {
            generateSudoku(matrix, level + 1, result);
            return;
        }
        int row = getCoordinate(location)[0] + (level / subLength) * subLength;
        int col = getCoordinate(location)[1] + (level % subLength) * subLength;

        if (matrix[row][col] != 0) { // wrong, needs also swap to
            generateSub(matrix, location + 1, level, result, set);
            return;
        }

        for (int i = location; i < length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            swap(nums, location, i);
            matrix[row][col] = nums[location];
            if (isValid(matrix, row, col)) {
                generateSub(matrix, location + 1, level, result, set);
            }
            swap(nums, location, i);
            matrix[row][col] = 0;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isValid(int[][] matrix, int row, int col) {
        int cur = matrix[row][col];
        for (int i = 0; i < matrix.length; i++) {
            if (i != row && matrix[i][col] == cur) {
                return false;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (j != col && matrix[row][j] == cur) {
                return false;
            }
        }
        return true;
    }

    private int[] getCoordinate(int location) {
        return new int[] {location / (subLength), location % (subLength)};
    }

    private void swap(int[][] matrix, int[] coord1, int[] coord2) {
        int tmp = matrix[coord1[0]][coord1[1]];
        matrix[coord2[0]][coord2[1]] = matrix[coord1[0]][coord1[1]];
        matrix[coord1[0]][coord1[1]] = tmp;
    }

    private void copyResult(int[][] src, int[][] des) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                des[i][j] = src[i][j];
            }
        }
    }
}
