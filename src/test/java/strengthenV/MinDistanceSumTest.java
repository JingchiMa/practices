package strengthenV;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class MinDistanceSumTest {
    @Test
    public void bestLocation() throws Exception {
        char[][] board = {
                {'e', 'x', 'x'},
                {'x', 'o', 'o'},
                {'e', 'o', 'x'}
        };
        MinDistanceSum instance = new MinDistanceSum();
        int[] expected = {1, 0};
        int[] res = instance.bestLocation(board);
        display(res);
        // assertArrayEquals(expected, );
    }

}