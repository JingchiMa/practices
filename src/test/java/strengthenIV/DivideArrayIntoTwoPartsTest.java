package strengthenIV;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DivideArrayIntoTwoPartsTest {
    private static DivideArrayIntoTwoParts instance = new DivideArrayIntoTwoParts();
    @Test
    public void twoPartsWithClosetSum() throws Exception {
        int[] nums = {2, 4, 2, 1, 3, 4};
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,3,4));
        assertEquals(expected, instance.twoPartsWithClosetSum(nums));
    }

    @Test
    public void closetSumDPTest() {
        int[] nums = {2, 4, 2, 1, 3, 4};
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 2));
        assertEquals(expected, instance.closestSum(nums));
    }

    @Test
    public void closetSumDPTestII() {
        int[] nums = {10, 4, 21, 1, 3, 4};
        List<Integer> expected = new ArrayList<>(Arrays.asList(21));
        assertEquals(expected, instance.closestSum(nums));
    }

}