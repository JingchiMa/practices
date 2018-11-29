package strengthenII;

import org.junit.Test;

import static org.junit.Assert.*;

public class CutRodAtGivenLocationTest {
    @Test
    public void minCost() throws Exception {
        CutRodAtGivenLocation instance = new CutRodAtGivenLocation();
        assertEquals(6, instance.minCost(4, new int[] {1, 2}));
    }

    public void minCostTestII() throws Exception {
        CutRodAtGivenLocation instance = new CutRodAtGivenLocation();
        assertEquals(6, instance.minCost(4, new int[] {1, 2}));
    }

}