package interviews.AppDynamics;

import java.util.*;

public class WordBreak {

    private final Set<String> words = new HashSet<>();
    public WordBreak(String[] words) {
        Collections.addAll(this.words, words);
    }

    List<String> wordBreak(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new StringBuilder(), new ArrayList<>(), result);
        return result.isEmpty() ? new ArrayList<>() : result.get(0);
    }

    private void dfs(int index, String s, StringBuilder sub, List<String> path, List<List<String>> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (index == s.length()) {
            if (isWord(sub.toString())) {
                path.add(sub.toString());
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            } else if (sub.length() == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        sub.append(s.charAt(index));
        if (isWord(sub.toString())) {
            path.add(sub.toString());
            dfs(index+1, s, new StringBuilder(), path, result);
            path.remove(path.size() - 1);
        }
        dfs(index + 1, s, sub, path, result);
        sub.deleteCharAt(sub.length() - 1);
    }

    private boolean isWord(String s) {
        return words.contains(s);
    }

}
