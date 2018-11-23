package strengthenIV;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourSumTest {
    @Test
    public void fourSum() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {-2, 6, 10, -5, -5, -3};
        int target = 0;
        assertEquals(true, instance.fourSumII(nums, target));
    }

    @Test
    public void fourSumNumberTest() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {-2, 6, 10, -5, -5, -3};
        int target = 0;
        assertEquals(1, instance.fourSumNumber(nums, target));
    }

    @Test
    public void fourSumNumberTest2() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        assertEquals(3, instance.fourSumNumber(nums, target));
    }

    @Test
    public void fourSumNumberTest3() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {-2, -2, -2, -2, -3, -3};
        int target = -9;
        assertEquals(1, instance.fourSumNumber(nums, target));
    }

    @Test
    public void fourSumNumberTest4() throws Exception {
        FourSum instance = new FourSum();
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        assertEquals(4, instance.fourSumNumber(nums, target));
    }
}