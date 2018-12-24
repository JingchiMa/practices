package thumbtack;

import java.util.*;

public class SubstringWithConcatenationWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        // will there be duplicates in the words?

        /*
        boolean isWord

        Map<word, # occurrences> map
        int toMatch

        L: length of each word

        [left, right] substring
        scan next L words,
            if is not a word, move left to right
            else
                if valid (i.e. # occurrences > 0), then update map and toMatch
                else move left (left++) until the valid again
            if toMatch == 0
                add left to results
                left++ by L and update map
        */

        List<Integer> results = new ArrayList<>();
        int len = words[0].length();

        // need to iterate through left = [0, L-1]
        for (int start = 0; start < len; start++) {
            findResults(start, results, words, s);
        }
        return results;
    }

    private void findResults(int start, List<Integer> results, String[] words, String s) {
        int left = start;
        int right = start; // [left, right] substring to visit
        Map<String, Integer> map = getMap(words);
        int toMatch = map.size();
        int len = words[0].length();
        while (right + len <= s.length()) {
            String cur = s.substring(right, right + len);
            if (!isWord(map, cur)) {
                // forgot to restore map
                while (left + len <= right) {
                    String leftString = s.substring(left, left + len);
                    toMatch += restoreMap(map, leftString);
                    left += len;
                }
                left += len;
                right += len;
            } else {
                int num = map.get(cur);
                if (num > 0) {
                    map.put(cur, num - 1);
                    if (num == 1) {
                        toMatch--;
                    }
                    if (toMatch == 0) {
                        results.add(left);
                        String leftString = s.substring(left, left + len);
                        toMatch += restoreMap(map, leftString);
                        left += len;
                    }
                } else {
                    String leftString = s.substring(left, left + len);
                    while (!leftString.equals(cur)) { // todo: not using substring
                        left += len;
                        toMatch += restoreMap(map, leftString);
                        leftString = s.substring(left, left + len);
                    }
                    left += len;
                }
                right += len;
            }
        }
    }

    private int restoreMap(Map<String, Integer> map, String s) {
        int num = map.get(s);
        map.put(s, num + 1);
        if (num == 0) {
            return 1;
        }
        return 0;
    }

    private boolean isWord(Map<String, Integer> map, String s) {
        return map.containsKey(s);
    }

    private Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int num = map.getOrDefault(word, 0);
            map.put(word, num + 1);
        }
        return map;
    }
}
