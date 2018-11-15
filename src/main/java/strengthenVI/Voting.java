package strengthenVI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Voting {
    public int findMajority(int[] nums, int k) {
        // number -> # occurrences
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int num : nums) {
            int appearance = candidates.getOrDefault(num, 0);
            if (appearance != 0 || candidates.size() < k - 1) {
                candidates.put(num, appearance + 1);
            } else {
                updateMap(candidates);
            }
        }
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int num : nums) {
            if (candidates.containsKey(num)) {
                int appearance = numbers.getOrDefault(num, 0);
                numbers.put(num, appearance + 1);
                if (appearance > nums.length / k) {
                    return num;
                }
            }
        }
        return -1;
    }

    private void updateMap(Map<Integer, Integer> map) {
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Integer, Integer> cur = iterator.next();
            cur.setValue(cur.getValue() - 1);
            if (cur.getValue() == 0) {
                iterator.remove();
            }
        }
    }

}
