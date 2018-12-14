package interviews.Houzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        for (String cur : strs) {
            Map<Character, Integer> key = getMap(cur);
            List<String> strings = map.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
                map.put(key, strings);
                results.add(strings);
            }
            strings.add(cur);
        }
        return results;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), num + 1);
        }
        return map;
    }

}
