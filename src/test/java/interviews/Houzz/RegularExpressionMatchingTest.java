package interviews.Houzz;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {
    @Test
    public void isMatch() throws Exception {
        RegularExpressionMatching instance = new RegularExpressionMatching();
        System.out.println(instance.isMatch("aa", "a*"));
    }

}