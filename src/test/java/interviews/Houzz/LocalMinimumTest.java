package interviews.Houzz;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LocalMinimumTest {

    private static LocalMinimum instance = new LocalMinimum();

    private static int[][] inputs = {
            {3, 2, 1, 4, 1, 4},
            {3, 2, 4},
            {5, 4, 2, 1, 0, 4}
    };

    private static Set<Integer>[] results = (Set<Integer>[]) new Set[3];

    @BeforeClass
    public static void setUp() {
        for (int i = 0; i < results.length; i++) {
            results[i] = new HashSet<>();
        }
        results[0].add(2);
        results[0].add(4);
        results[1].add(1);
        results[2].add(4);
    }

    @Test
    public void localMinimumTest() throws Exception {
        int i = 0;
        for (int[] input : inputs) {
            assertTrue(results[i].contains(instance.localMinimum(input)));
            i++;
        }
    }

    @Test
    public void localMinimumIITest() throws Exception {
        int i = 0;
        for (int[] input : inputs) {
            assertTrue(results[i].contains(instance.localMinimumII(input)));
            i++;
        }
    }

}