package strengthenV;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHistogramTest {
    @Test
    public void maxHistogramTest() throws Exception {
        MaxHistogram instance = new MaxHistogram();
        assertEquals(4, instance.maxHistogram(new int[] {2, 4}));
    }

}