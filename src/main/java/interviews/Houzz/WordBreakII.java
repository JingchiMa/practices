package interviews.Houzz;

import java.util.*;

public class WordBreakII {

    // naive dfs
    public List<String> wordBreak(String s, List<String> wordDict) {
        /*
        Suppose the length of s is n.
        dfs: n + 1 levels (0 <= i <= n)
        level i: cut at index i or not
        */
        List<String> results = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        dfs(s, 0, 0, dict, new ArrayList<>(), results);
        return results;
    }

    // prev is inclusive
    private void dfs(String s, int prev, int index, Set<String> dict, List<String> path, List<String> results) {
        if (index >= s.length()) {
            if (prev >= s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String word : path) {
                    sb.append(word).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                results.add(sb.toString());
            }
            return;
        }
        dfs(s, prev, index + 1, dict, path, results);
        String cur = s.substring(prev, index + 1);
        if (dict.contains(cur)) {
            path.add(cur);
            dfs(s, index + 1, index + 1, dict, path, results);
            path.remove(path.size() - 1);
        }
    }

    // dfs with memorization
    public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        return helper(s, dict, new HashMap<>());
    }

    private List<String> helper(String s, Set<String> dict, Map<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> results = new ArrayList<>();
        if (s.length() == 0) {
            results.add("");
            return results;
        }
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(0, i + 1);
            if (dict.contains(cur)) {
                List<String> subResults = helper(s.substring(i + 1), dict, cache); // default is begin index
                for (String subString : subResults) {
                    if (subString.length() == 0) {
                        results.add(cur);
                    } else {
                        results.add(cur + " " + subString);
                    }
                }
            }
        }
        cache.put(s, results);
        return results;
    }
}
