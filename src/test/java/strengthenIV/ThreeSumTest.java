package strengthenIV;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    @Test
    public void threeSum() throws Exception {
        ThreeSum instance = new ThreeSum();
        int[] input = {5, 3, 6, 8, 10, 1, 0, 5, 0};
        int target = 10;
        System.out.println(instance.threeSum(input, target));
    }

}