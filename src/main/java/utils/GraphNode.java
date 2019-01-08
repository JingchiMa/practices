package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(int val) {
        this.val = val;
    }

    public static Map<Integer, GraphNode> buildGraph(int[][] input) {
        Map<Integer, GraphNode> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.putIfAbsent(i, new GraphNode(i));
            GraphNode cur = map.get(i);
            for (int neighborVal : input[i]) {
                GraphNode neighborNode = map.get(neighborVal);
                if (neighborNode == null) {
                    neighborNode = new GraphNode(neighborVal);
                    map.put(neighborVal, neighborNode);
                }
                cur.neighbors.add(neighborNode);
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
