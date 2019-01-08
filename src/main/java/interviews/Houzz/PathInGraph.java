package interviews.Houzz;

import utils.GraphNode;

import java.util.*;

public class PathInGraph {

    List<List<GraphNode>> allPaths(List<GraphNode> graph, GraphNode src, GraphNode dst, int n) {
        List<GraphNode> path = new ArrayList<>();
        List<List<GraphNode>> results = new ArrayList<>();
        path.add(src);
        dfs(src, n, dst, path, results);
        return results;
    }

    private void dfs(GraphNode cur, int n, GraphNode dst, List<GraphNode> path, List<List<GraphNode>> results) {
        if (path.size() == n && cur == dst) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (path.size() == n || cur == dst) {
            return;
        }
        for (GraphNode neighbor : cur.neighbors) {
            path.add(neighbor);
            dfs(neighbor, n, dst, path, results);
            path.remove(path.size() - 1);
        }
    }

    int pathNum(GraphNode src, GraphNode dst, int k) {
        return helper(src, dst, k - 1);
    }

    // step is # nodes left
    private int helper(GraphNode cur, GraphNode src, int step) {
        if (step == 0 && cur == src) {
            return 1;
        }
        if (step == 0 || cur == src) {
            return 0;
        }
        int res = 0;
        for (GraphNode neighbor : cur.neighbors) {
            res += helper(neighbor, src, step - 1);
        }
        return res;
    }

    // use topological order of the subgraph
    // assume the input is a DAG
    int pathNumII(GraphNode src, GraphNode dst, int k) {
        Map<GraphNode, Integer> indegrees = new HashMap<>();
        List<GraphNode> path = new ArrayList<>();
        path.add(src);
        dfs(src, dst, path, k - 1, indegrees);

        List<GraphNode> topologicalOrder = new ArrayList<>();
        topologicalOrder.addAll(indegrees.keySet());
        Collections.sort(topologicalOrder, new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode o1, GraphNode o2) {
                return indegrees.get(o1) - indegrees.get(o2);
            }
        });

        Map<GraphNode, Integer> pathNums = new HashMap<>();
        pathNums.put(src, 1);
        for (GraphNode node : topologicalOrder) {
            for (GraphNode neighbor : node.neighbors) {
                if (indegrees.containsKey(neighbor)) {
                    pathNums.put(neighbor, pathNums.getOrDefault(neighbor, 0) + pathNums.get(node));
                }
            }
        }
        return pathNums.get(dst);
    }

    private void dfs(GraphNode cur, GraphNode dst, List<GraphNode> path, int k, Map<GraphNode, Integer> indegrees) {
        if (k == 0 && dst == cur) {
            for (int i = 1; i < path.size(); i++) {
                int indegree = indegrees.getOrDefault(path.get(i), 0);
                indegrees.put(path.get(i), indegree + 1);
            }
            return;
        }
        if (k == 0 || dst == cur) {
            return;
        }
        for (GraphNode neighbor : cur.neighbors) {
            path.add(neighbor);
            dfs(neighbor, dst, path, k - 1, indegrees);
            path.remove(path.size() - 1);
        }
    }




}
