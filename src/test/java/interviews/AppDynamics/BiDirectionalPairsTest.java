package interviews.AppDynamics;

import org.junit.Test;

import static org.junit.Assert.*;

public class BiDirectionalPairsTest {
    @Test
    public void findBiDirectionalPairs() throws Exception {
        BiDirectionalPairs instance = new BiDirectionalPairs();
        /*

         */
        int[][] graph = {{1, 2, 3}, {2, 3}, {1}, {0}};
        System.out.println(instance.findBiDirectionalPairs(graph));
    }

}