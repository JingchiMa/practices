package strengthenI;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {
    @Test
    public void kthLargestElement() throws Exception {
        QuickSelect instance = new QuickSelect();
        instance.kthLargestElement(10, new int[] {1,2,3,4,5,6,8,9,10,7});
    }

}