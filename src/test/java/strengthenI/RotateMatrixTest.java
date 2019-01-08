package strengthenI;

import org.junit.Test;
import utils.Display;

import static org.junit.Assert.*;

public class RotateMatrixTest {
    @Test
    public void rotate() throws Exception {
        RotateMatrix instance = new RotateMatrix();
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        instance.rotate(matrix);
        Display.display(matrix);
    }

}