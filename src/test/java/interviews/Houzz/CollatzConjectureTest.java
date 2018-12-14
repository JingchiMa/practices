package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class CollatzConjectureTest {
    @Test
    public void findLongestSequence() throws Exception {
        CollatzConjecture instance = new CollatzConjecture();
        System.out.println(instance.findLongestSequence(100000));
    }

}