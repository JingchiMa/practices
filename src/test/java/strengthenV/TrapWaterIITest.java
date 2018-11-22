package strengthenV;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrapWaterIITest {
    @Test
    public void trapRainWater() throws Exception {
        TrapWaterII instance = new TrapWaterII();
        int[][] heights = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(instance.trapRainWater(heights));
    }

}