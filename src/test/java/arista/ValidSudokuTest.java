package arista;

import org.junit.Test;
import strengthenIV.ValidParentheses;

import static org.junit.Assert.*;

public class ValidSudokuTest {
    @Test
    public void generateSudoku() throws Exception {
        int length = 9;
        int subLength = 3;
        int[][] matrix = new int[length][length];
        ValidSudoku instance = new ValidSudoku(length,subLength);
        instance.generateSudoku(matrix);
    }

    @Test
    public void generateSudokuTest2() throws Exception {
        int length = 4;
        int subLength = 2;
        int[][] matrix = new int[length][length];
        matrix[0][0] = 2;
        ValidSudoku instance = new ValidSudoku(length,subLength);
        instance.generateSudoku(matrix);
    }

}