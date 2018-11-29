package strengthenII;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeStonesTest {
    @Test
    public void minCost() throws Exception {
        MergeStones instance = new MergeStones();
        assertEquals(18, instance.minCost(new int[] {4, 1, 1, 4}));
    }

    @Test
    public void minCostTest2() throws Exception {
        MergeStones instance = new MergeStones();
        assertEquals(8, instance.minCost(new int[] {1,1,1,1}));
    }

    @Test
    public void minCostTest3() throws Exception {
        MergeStones instance = new MergeStones();
        assertEquals(43, instance.minCost(new int[] {4, 4, 5, 9}));
    }

}