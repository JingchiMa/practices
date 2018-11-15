package strengthenVI;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstNonRepeatingTest {
    @Test
    public void nextTest1() throws Exception {
        FirstNonRepeating instance = new FirstNonRepeating();
        char[] input = {'1', '2', '3', '1', '5', '2', '3', '5'};
        Character[] expected = {'1', '1', '1', '2', '2', '3', '5', null};
        for (int i = 0; i < input.length; i++) {
            assertEquals(expected[i], instance.next(input[i]));
        }
    }

    @Test
    public void nextTest2() throws Exception {
        FirstNonRepeating instance = new FirstNonRepeating();
        char[] input = {'1', '1', '1', '2'};
        Character[] expected = {'1', null, null, '2'};
        for (int i = 0; i < input.length; i++) {
            assertEquals(expected[i], instance.next(input[i]));
        }
    }

}