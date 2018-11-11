package strengthenVI;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class KthElementInArraysTest {
    @Test
    public void kthElementI() throws Exception {
        int[] array1 = {1, 4, 6, 7};
        int[] array2 = {2, 4, 5};
        int k = 3;
        int expected = 4;
        assertEquals(expected, KthElementInArrays.kthElementI(array1, array2, k));
    }

    @Test
    public void kthElementII() throws Exception {
        int[] array1 = {1, 4, 6, 7};
        int[] array2 = {2, 4, 5};
        int k = 3;
        int expected = 4;
        assertEquals(expected, KthElementInArrays.findKth(array1, 0,  array2, 0, k));
    }

    @Test
    public void findFirstKTest1() throws Exception {
        int[] array1 = {1, 4, 6, 7};
        int[] array2 = {2, 4, 5};
        int k = 3;
        int[] expected = {1, 0};
        int[] res = KthElementInArrays.findFirstK(array1, array2, k);
        assertArrayEquals(expected, res);
    }

    @Test
    public void findFirstKTest2() throws Exception {
        int[] array1 = {1, 4, 6, 7};
        int[] array2 = {0, 0, 0};
        int k = 3;
        int[] expected = {-1, 2};
        int[] res = KthElementInArrays.findFirstK(array1, array2, k);
        assertArrayEquals(expected, res);
    }

    @Test
    public void findKthInArraysTest1() {
        KthElementInArrays instance = new KthElementInArrays();
        int[][] arrays = {{1, 5, 7, 10}, {2, 3, 8}, {1, 6, 7, 11}, {4, 5}};
        int k = 8;
        int expected = 7;
        assertEquals(expected, instance.findKthInArrays(arrays, k));
    }

    @Test
    public void findKthInArraysTest2() {
        KthElementInArrays instance = new KthElementInArrays();
        int[][] arrays = {{1, 5, 7, 10}, {2, 3, 8}, {1, 6, 7, 11}, {4, 5}};
        int k = 5;
        int expected = 4;
        assertEquals(expected, instance.findKthInArrays(arrays, k));
    }

}