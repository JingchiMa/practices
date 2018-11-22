package midtermReview;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;

public class FactorMultiplicationsTest {
    @Test
    public void allPossibleFactors() throws Exception {
        FactorMultiplications instance = new FactorMultiplications();
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2,2,2)));
        expected.add(new ArrayList<>(Arrays.asList(2, 4)));
        List<List<Integer>> results = instance.allPossibleFactors(8);
        assertThat(expected, containsInAnyOrder(results.toArray()));
    }

    @Test
    public void allPossibleFactorsTestII() throws Exception {
        FactorMultiplications instance = new FactorMultiplications();
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2, 8)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 4)));
        expected.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2)));
        expected.add(new ArrayList<>(Arrays.asList(4, 4)));
        List<List<Integer>> results = instance.allPossibleFactors(16);
        assertThat(expected, containsInAnyOrder(results.toArray()));
    }

}