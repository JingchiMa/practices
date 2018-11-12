package thumbtack;

import java.util.*;

public class MapSubset {

    // Question 1

    public List<Map<String, String>> getMapSubset(Map<String, String> map) {
        List<String> keys = new ArrayList<>(map.keySet());
        List<Map<String, String>> results = new ArrayList<>();
        dfs(map, keys, 0, new HashMap<>(), results);
        return results;
    }

    private void dfs(Map<String, String> map, List<String> keys,
                     int index, Map<String, String> path,
                     List<Map<String, String>> results) {
        if (index == keys.size()) {
            if (path.size() != 0) {
                results.add(new HashMap<>(path));
            }
            return;
        }
        path.put(keys.get(index), map.get(keys.get(index)));
        dfs(map, keys, index + 1, path, results);
        path.remove(keys.get(index));
        dfs(map, keys, index + 1, path, results);
    }

    // Question 2
    public List<Map<String, String>> subsetMaps(Map<String, String> map1, Map<String, String> map2) {
        List<Map<String, String> > results = new ArrayList<>();
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        dfs(map1, map2, new ArrayList<>(keys), 0, new HashMap<>(), results);
        return results;
    }

    private void dfs(Map<String, String> map1, Map<String, String> map2,
                     List<String> keys, int index, Map<String, String> path,
                     List<Map<String, String>> results) {
        if (index == keys.size()) {
            if (path.size() != 0) {
                results.add(new HashMap<>(path));
            }
            return;
        }
        dfs(map1, map2, keys, index + 1, path, results);
        String value1 = map1.get(keys.get(index));
        String value2 = map2.get(keys.get(index));
        if (value1 != null) {
            path.put(keys.get(index), value1);
            dfs(map1, map2, keys, index + 1, path, results);
            path.remove(keys.get(index));
        }
        if (value2 != null && !value2.equals(value1)) {
            path.put(keys.get(index), value2);
            dfs(map1, map2, keys, index + 1, path, results);
            path.remove(keys.get(index));
        }
    }

    // Question 3
    public Map<Map<String, String>, Integer> subMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<Map<String, String>, Integer> results = new HashMap<>();
        Map<Map.Entry<String, String>, Integer> entryMap = new HashMap<>();
        addEntries(entryMap, map1);
        addEntries(entryMap, map2);
        List<Map.Entry<Map.Entry<String, String>, Integer>> entryList = new ArrayList<>(entryMap.entrySet());
        dfs(entryList, 0, new ArrayList<>(), results);
        return results;
    }

    private void addEntries(Map<Map.Entry<String, String>, Integer> entries, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int num = entries.getOrDefault(entry, 0);
            entries.put(entry, num + 1);
        }
    }

    private void dfs(List<Map.Entry<Map.Entry<String, String>, Integer>> entryList, int index,
                     List<Map.Entry<Map.Entry<String, String>, Integer>> path,
                     Map<Map<String, String>, Integer> results) {
        if (index == entryList.size()) {
            if (path.size() != 0) {
                Map<String, String> map = new HashMap<>();
                int count = 1;
                for (Map.Entry<Map.Entry<String, String>, Integer> entry : path) {
                    map.put(entry.getKey().getKey(), entry.getKey().getValue());
                    count *= entry.getValue();
                }
                results.put(map, count);
            }
            return;
        }
        dfs(entryList, index + 1, path, results);
        path.add(entryList.get(index));
        dfs(entryList, index + 1, path, results);
        path.remove(path.size() - 1);
    }

}
