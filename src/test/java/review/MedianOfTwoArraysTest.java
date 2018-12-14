package review;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfTwoArraysTest {
    private static final MedianOfTwoArrays instance = new MedianOfTwoArrays();
    @Test
    public void medianUnsorted() throws Exception {
        int[] a = {9,11,5,10,8};
        int[] b = {3,4,2};
        System.out.println(instance.medianUnsorted(a, b));
    }

}