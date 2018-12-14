package strengthenI;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class DeduplicationInArrayTest {
    private  static final DeduplicationInArray instance = new DeduplicationInArray();
    @Test
    public void deduplicateI() throws Exception {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4};
        int[] expected = {1, 1, 2, 2, 3, 3, 4};
        assertArrayEquals(expected, instance.deduplicateI(nums));
    }

    @Test
    public void deduplicateII() {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4};
        int[] expected = {4};
        int[] res = instance.deduplicateII(nums);
        assertArrayEquals(expected, res);
    }

    @Test
    public void recursivelyDeduplicate() {
        int[] nums = {1, 2, 2, 2, 1, 1, 4, 3, 2, 2, 4};
        int[] expected = {4, 3, 4};
        int[] res = instance.recursivelyDeduplicate(nums);
        assertArrayEquals(expected, res);
    }

    @Test
    public void pushBackZeros() {
        int[] nums = {1, 0, 3 ,5 ,0, 0, 7, 11};
        int[] expected = {1, 3, 5, 7, 11, 0, 0, 0};
        instance.pushBackZeros(nums);
        assertArrayEquals(expected, nums);
    }

}