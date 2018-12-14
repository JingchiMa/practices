package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumMatrixTest {
    @Test
    public void sumRegion() throws Exception {
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix instance = new NumMatrix(matrix);
        System.out.println(instance.sumRegion(2, 1, 4, 3));
    }

}