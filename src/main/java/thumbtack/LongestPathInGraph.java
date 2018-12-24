package thumbtack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GraphNode {
    int val;
    List<GraphNode> neighbors;

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return val + "";
    }
}
public class LongestPathInGraph {

//    public List<GraphNode> longestPath(List<GraphNode> graph) {
//        // base case: (1) no neighbors anymore (2) meet a node in the path
//
//        for (GraphNode )
//        return new ArrayList<>();
//    }
//
//    // cur has been added into path before entering the method
//    private int dfs(GraphNode cur, Set<GraphNode> path, Map<GraphNode, Integer> cache, int[] max) {
//        if (cache.containsKey(cur)) {
//            return cache.get(cur);
//        }
//        int maxLen = 1;
//        for (GraphNode neighbor : cur.neighbors) {
//            if (!path.add(neighbor)) {
//                maxLen =
//                continue;
//            }
//            maxLen = Math.max(maxLen, dfs(neighbor, path, cache, max) + 1);
//        }
//        cache.put(cur, maxLen);
//        max[0] = Math.max(max[0], maxLen);
//        return maxLen;
//    }

    List<GraphNode> longestCycle(List<GraphNode> graph) {
        return new ArrayList<>();
    }
}
