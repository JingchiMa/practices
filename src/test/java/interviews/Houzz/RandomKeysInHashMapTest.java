package interviews.Houzz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RandomKeysInHashMapTest {
    @Test
    public void randomPrint() throws Exception {
        RandomKeysInHashMap instance = new RandomKeysInHashMap();
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 50);
        map.put("b", 25);
        map.put("c", 25);

        Map<String, Integer> occurrences = new HashMap<>();
        final int num = 10000;
        for (int i = 0; i < num; i++) {
            String res = instance.randomPrint(map);
            occurrences.put(res, occurrences.getOrDefault(res, 0) + 1);
        }
        System.out.println(occurrences);
    }

}