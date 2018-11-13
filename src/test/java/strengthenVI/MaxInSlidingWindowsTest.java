package strengthenVI;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class MaxInSlidingWindowsTest {

    private static final MaxInSlidingWindows instance = new MaxInSlidingWindows();
    @Test
    public void maxsInSlidingWindows() throws Exception {
        int[] nums = {1, 6, 8, 5, 4, 7, 3, 2};
        int k = 3;
        int[] res = instance.maxsInSlidingWindows(nums, k);
        int[] expected = {8, 8, 8, 7, 7, 7};
        assertArrayEquals(expected, res);
    }

    @Test
    public void maxsInSlidingWindowsII() throws Exception {
        int[] nums = {1, 6, 8, 5, 4, 7, 3, 2};
        int k = 3;
        int[] res = instance.maxsInSlidingWindows(nums, k);
        int[] expected = {8, 8, 8, 7, 7, 7};
        assertArrayEquals(expected, res);
    }

}