package interviews.AppDynamics;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterFrequencyTest {
    @Test
    public void frequencies() throws Exception {
        LetterFrequency instance = new LetterFrequency();
        String s = "abeaeeed";
        System.out.println(instance.frequencies(s));
    }

}