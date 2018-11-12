package thumbtack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapSubsetTest {
    @Test
    public void getMapSubset() throws Exception {
        MapSubset instance = new MapSubset();
        Map<String, String> map = new HashMap<>();
        map.put("1", "Good");
        map.put("2", "Better");
        map.put("3", "Best");
        System.out.println(instance.getMapSubset(map));
    }

    @Test
    public void subsetMapsTest() {
        MapSubset instance = new MapSubset();
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "I");
        map1.put("2", "II");
        map1.put("3", "III");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "ONE");
        map2.put("2", "TWO");
        map2.put("3", "III");
        assertEquals(3 * 3 * 2 - 1, instance.subsetMaps(map1, map2).size());
    }

    @Test
    public void subMapsTest() {
        MapSubset instance = new MapSubset();
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "I");
        map1.put("2", "II");
        // map1.put("3", "III");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "ONE");
        map2.put("2", "II");
        // map2.put("3", "III");
        System.out.println(instance.subMaps(map1, map2));
    }
}