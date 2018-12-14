package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumsTest {
    @Test
    public void allPairsTest1() throws Exception {
        TwoSums instance = new TwoSums();
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4};
        int target = 4;
        System.out.println(instance.allPairs(nums, target));
    }

    @Test
    public void allPairsTest2() throws Exception {
        TwoSums instance = new TwoSums();
        int[] nums = {1, 2, 2, 2, 2, 3, 3, 4};
        int target = 4;
        System.out.println(instance.allPairs(nums, target));
    }

    @Test
    public void allPairsTest3() throws Exception {
        TwoSums instance = new TwoSums();
        int[] nums = {1};
        int target = 4;
        System.out.println(instance.allPairs(nums, target));
    }

    @Test
    public void kNumbersTest1() throws Exception {
        TwoSums instance = new TwoSums();
        int[] nums = {1, 2, 3, 4, 0, 0, 9, 2, 2}; // 1 2 3 4, 2 2 2 4, 9 1 0 0
        int k = 4;
        int target = 10;
        System.out.println(instance.kNumbers(nums, k, target));
    }



}