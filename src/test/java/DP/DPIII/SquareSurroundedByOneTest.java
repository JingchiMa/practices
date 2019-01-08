package DP.DPIII;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSurroundedByOneTest {
    @Test
    public void largest() throws Exception {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0}
        };
        SquareSurroundedByOne instance = new SquareSurroundedByOne();
        System.out.println(instance.largest(matrix));
    }

}