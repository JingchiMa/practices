package strengthenVI;

import org.junit.Test;

import static org.junit.Assert.*;

public class VotingTest {
    @Test
    public void findMajority() throws Exception {
        Voting instance = new Voting();
        int[] nums = {1, 3, 1, 3, 2, 3, 1, 3, 3, 3, 3, 5, 6, 7, 3, 10};
        int k = 4;
        assertEquals(3, instance.findMajority(nums, k));
    }

}