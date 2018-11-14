package thumbtack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCollatzSequenceTest {

    private static final LongestCollatzSequence instance = new LongestCollatzSequence();
    @Test
    public void longestCollatzSequence() throws Exception {
        assertEquals(20, instance.longestCollatzSequence(19));
    }

    @Test
    public void sequenceLength() throws Exception {
        assertEquals(9, instance.longestCollatzSequence(12));
        assertEquals(20, instance.longestCollatzSequence(19));
    }

}