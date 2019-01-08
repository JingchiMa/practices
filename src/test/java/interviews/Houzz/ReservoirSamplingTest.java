package interviews.Houzz;

import org.junit.Test;
import utils.Display;

import static org.junit.Assert.*;

public class ReservoirSamplingTest {
    @Test
    public void getKElements() throws Exception {

        int k = 3;
        ReservoirSampling instance = new ReservoirSampling(k);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        for (int i = 0; i < nums.length; i++) {
            int[] res = instance.getKElements(nums[i]);
            if (i >= k) {
                Display.display(res);
            }
        }
    }

}