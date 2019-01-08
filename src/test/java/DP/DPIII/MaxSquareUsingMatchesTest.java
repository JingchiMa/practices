package DP.DPIII;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSquareUsingMatchesTest {
    @Test
    public void maxSquare() throws Exception {
        MaxSquareUsingMatches instance = new MaxSquareUsingMatches();
        Point[][] input = {
                { new Point(true, true), new Point(true, true), new Point(true, true) },
                { new Point(false, true), new Point(false, true), new Point(false, true) },
                { new Point(true, true), new Point(true, true), new Point(true, true) }
        };
        System.out.println(instance.maxSquare(input));
    }

}