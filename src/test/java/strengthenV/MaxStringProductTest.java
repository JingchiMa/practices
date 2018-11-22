package strengthenV;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaxStringProductTest {
    @Test
    public void findStringPair() throws Exception {
        MaxStringProduct instance = new MaxStringProduct();
        List<String> inputs = new ArrayList<>(Arrays.asList("Good", "Bad", "Beautiful", "GO!"));
        assertEquals(new ArrayList<>(Arrays.asList("Beautiful", "Good")), instance.findStringPair(inputs));
    }

    @Test
    public void findStringPairTest2() throws Exception {
        MaxStringProduct instance = new MaxStringProduct();
        List<String> inputs = new ArrayList<>(
                Arrays.asList("Good", "Bad", "FU", "GO!", "WHoT")
        );
        assertEquals(new ArrayList<>(Arrays.asList("WHoT", "Bad")), instance.findStringPair(inputs));
    }

}