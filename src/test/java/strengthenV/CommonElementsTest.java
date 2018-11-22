package strengthenV;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CommonElementsTest {

    private static final CommonElements instance = new CommonElements();

    @Test
    public void commonElementsInTwoSortedArrays() throws Exception {
        int[] array1 = {1, 2, 2, 2, 3, 4};
        int[] array2 = {2, 2, 3, 3, 4};
        int[] results = new int[Math.max(array1.length, array2.length)];
        int[] expected = {2, 3, 4};
        int size = instance.commonElementsInTwoSortedArrays(array1, array1.length, array2, array2.length, results);
        assertEquals(expected.length, size);
        for (int i = 0; i < size; i++) {
            assertEquals(expected[i], results[i]);
        }
    }

    @Test
    public void commonElementsInKSortedArrays() throws Exception {
        int[][] arrays = {{1, 3, 6, 8}, {3, 6, 8}, {2, 3, 4, 6, 7, 10}, {2, 3, 6}};
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(6);
        assertEquals(expected, instance.commonElementsInKSortedArrays(arrays));
    }



}