package interviews.AppDynamics;

import java.util.*;

public class BiDirectionalPairs {

    public List<List<Integer>> findBiDirectionalPairs(int[][] graph) {
        Set<List<Integer>> set = new HashSet<>();
        dfs(graph, 0, set, new HashSet<>());
        List<List<Integer>> results = new ArrayList<>();
        results.addAll(set);
        return results;
    }

    private void dfs(int[][] graph, int cur, Set<List<Integer>> set, Set<Integer> visited) {
        for (int neighbor : graph[cur]) {
            if (!visited.add(neighbor)) {
                continue;
            }
            int min = Math.min(cur, neighbor);
            int max = Math.max(cur, neighbor);
            List<Integer> pair = new ArrayList<>(Arrays.asList(min, max));
            if (contains(graph[neighbor], cur)) {
                set.add(pair);
            }
            dfs(graph, neighbor, set, visited);
        }
    }

    private boolean contains(int[] neighbors, int target) {
        for (int neighbor : neighbors) {
            if (neighbor == target) {
                return true;
            }
        }
        return false;
    }

}
