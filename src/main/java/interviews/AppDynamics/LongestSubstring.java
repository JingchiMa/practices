package interviews.AppDynamics;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public String maxSubstringWithKUnique(String s, int k) {
        // sanity check
        int left = 0;
        int right = 0;
        int globalMax = 0;
        int globalLeft = 0;
        int globalRight = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        while (right < s.length()) {
            while (right < s.length() && count < k) {
                count += updateMap(map, s.charAt(right));
                right++;
            }
            if (count == k) {
                if (right - left > globalMax) {
                    globalMax = right - left;
                    globalLeft = left;
                    globalRight = right;
                }
                while (left < right && count >= k) {
                    count += restoreMap(map, s.charAt(left));
                    left++;
                }
            }
        }
        return s.substring(globalLeft, globalRight);
    }

    // update map and return the change in # unique characters
    private int updateMap(Map<Character, Integer> map, char cur) {
        int num = map.getOrDefault(cur, 0);
        map.put(cur, num + 1);
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return -1;
        } else {
            return 0;
        }
    }

    // update map and return the change in # unique characters
    private int restoreMap(Map<Character, Integer> map, char cur) {
        int num = map.get(cur); // cur will always be in the map
        map.put(cur, num - 1);
        if (num == 1) {
            return -1;
        } else if (num == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    public String maxStringWithKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int globalLeft = 0;
        int globalRight = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            while (right < s.length() && map.size() <= k) {
                int num = map.getOrDefault(s.charAt(right), 0);
                map.put(s.charAt(right), num + 1);
                right++;
            }
            if (map.size() > k) {
                if (right - 1 - left > max) {
                    max = right - 1 - left;
                    globalLeft = left;
                    globalRight = right - 1;
                }
                while (left < right && map.size() > k) {
                    int num = map.get(s.charAt(left));
                    if (num == 1) {
                        map.remove(s.charAt(left));
                    } else {
                        map.put(s.charAt(left), num - 1);
                    }
                    left++;
                }
            }
        }
        return s.substring(globalLeft, globalRight);

    }
}
