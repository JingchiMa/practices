package strengthenIV;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetOfSizeKTest {
    @Test
    public void subsetOfSizeK() throws Exception {
        SubsetOfSizeK instance = new SubsetOfSizeK();
        int[] nums = {1, 3, 2, 6};
        int k = 2;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1,2)));
        expected.add(new ArrayList<>(Arrays.asList(1,3)));
        expected.add(new ArrayList<>(Arrays.asList(1,6)));
        expected.add(new ArrayList<>(Arrays.asList(2,3)));
        expected.add(new ArrayList<>(Arrays.asList(2,6)));
        expected.add(new ArrayList<>(Arrays.asList(3,6)));
        assertEquals(expected, instance.subsetOfSizeK(nums, k));
    }

    @Test
    public void subsetOfSizeKTest() throws Exception {
        SubsetOfSizeK instance = new SubsetOfSizeK();
        int[] nums = {1, 2, 6, 2};
        int k = 2;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1,2)));
        expected.add(new ArrayList<>(Arrays.asList(1,6)));
        expected.add(new ArrayList<>(Arrays.asList(2,2)));
        expected.add(new ArrayList<>(Arrays.asList(2,6)));
        assertEquals(expected, instance.subsetOfSizeK(nums, k));
    }

}