package strengthenVI;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class KthClosestTest {
    @Test
    public void kClosestTest1() throws Exception {
        KthClosest instance = new KthClosest();
        int[] nums = {1, 4 ,6, 8, 9, 10};
        int target = 5;
        int k = 3;
        int[] expected = {1, 3};
        int[] res = instance.kClosest(nums, target, k);
        assertArrayEquals(expected, res);
    }

    @Test
    public void kClosestTest2() throws Exception {
        KthClosest instance = new KthClosest();
        int[] nums = {1, 4 ,6, 8, 9, 10};
        int target = 8;
        int k = 1;
        int[] expected = {3, 3};
        int[] res = instance.kClosest(nums, target, k);
        assertArrayEquals(expected, res);
    }

    @Test
    public void kClosestTest3() throws Exception {
        KthClosest instance = new KthClosest();
        int[] nums = {1, 4 ,6, 8, 9, 10};
        int target = 11;
        int k = 3;
        int[] expected = {3, 5};
        int[] res = instance.kClosest(nums, target, k);
        assertArrayEquals(expected, res);
    }

    @Test
    public void kClosestTest4() throws Exception {
        KthClosest instance = new KthClosest();
        int[] nums = {1, 4 ,6, 8, 9, 10};
        int target = 0;
        int k = 3;
        int[] expected = {0, 2};
        int[] res = instance.kClosest(nums, target, k);
        assertArrayEquals(expected, res);
    }

}