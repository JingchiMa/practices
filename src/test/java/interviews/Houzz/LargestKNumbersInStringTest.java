package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestKNumbersInStringTest {
    @Test
    public void largestK() throws Exception {
        LargestKNumbersInString instance = new LargestKNumbersInString();
        String s = "dfsfs980sdf123poier110poipoikkj-10";
        int k = 4;
        System.out.println(instance.largestK(s, k));
    }

}