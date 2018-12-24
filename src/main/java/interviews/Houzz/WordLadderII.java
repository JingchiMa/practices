package interviews.Houzz;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // step 1: find the length of shortest path -> bfs
        // step 2: dfs to find all paths (1) ends at endWord (2) length = shortest len
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        int len = getShortestLen(beginWord, endWord, dict);
        if (len == -1) {
            return new ArrayList<>();
        }
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, 1, endWord, new HashSet<>(), dict, len, path, results);
        return results;
    }

    // at most len levels
    // each level: the possible next steps.
    private void dfs(String cur, int step, String endWord, Set<String> visited,
                     Set<String> dict, int len, List<String> path, List<List<String>> results) {
        if (step == len && cur.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (step >= len) {
            return;
        }
        List<String> neighbors = getNeighbors(cur, dict);
        for (String neighbor : neighbors) {
            if (visited.add(neighbor)) {
                path.add(neighbor);
                dfs(neighbor, step + 1, endWord, visited, dict, len, path, results);
                path.remove(path.size() - 1);
                visited.remove(neighbor);
            }
        }
    }

    private List<String> getNeighbors(String cur, Set<String> dict) {
        char[] array = cur.toCharArray();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            char tmp = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (tmp == c) {
                    continue;
                }
                array[i] = c;
                String next = new String(array);
                if (dict.contains(next)) {
                    results.add(next);
                }
            }
            array[i] = tmp;
        }
        return results;
    }

    // return the length of the shortest path from beginWord to endWord, -1 if no such path
    private int getShortestLen(String beginWord, String endWord, Set<String> dict) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        int step = 1; // the length of current path
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                for (String neighbor : getNeighbors(cur, dict)) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
