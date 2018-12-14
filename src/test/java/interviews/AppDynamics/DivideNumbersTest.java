package interviews.AppDynamics;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideNumbersTest {
    @Test
    public void divideIntoConsecutiveGroups() throws Exception {
        DivideNumbers instance = new DivideNumbers();
        int[] nums = {8,2,4,7,1,0,3,6};
        System.out.println(instance.DivideIntoConsecutiveGroups(nums));
    }

}