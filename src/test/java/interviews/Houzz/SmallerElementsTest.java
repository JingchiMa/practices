package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallerElementsTest {
    @Test
    public void smallerElements() throws Exception {
        SmallerElements instance = new SmallerElements();
        int[] nums = {1, 3, 0, 7, 10, 8, 6};
        int[] expected = {-1, 1, -1, 0, 7, 7, 0};
        assertArrayEquals(expected, instance.smallerElements(nums));
    }

    @Test
    public void smallerElementsII() throws Exception {
        SmallerElements instance = new SmallerElements();
        int[] nums = {1, 3, 0, 7, 10, 8, 6};
        int[] expected = {-1, 1, -1, 0, 7, 7, 0};
        assertArrayEquals(expected, instance.smallerElemenetsII(nums));
    }

}