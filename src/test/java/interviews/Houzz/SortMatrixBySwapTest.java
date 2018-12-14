package interviews.Houzz;

import org.junit.Test;
import utils.Display;

import java.util.List;

import static org.junit.Assert.*;

public class SortMatrixBySwapTest {
    @Test
    public void printPath() throws Exception {
        SortMatrixBySwap instance = new SortMatrixBySwap();
        int[][] board = {{3, 1}, {2, 4}};
        List<int[]> results = instance.printPath(board);
        for (int[] cell : results) {
            Display.display(cell);
        }
    }

}