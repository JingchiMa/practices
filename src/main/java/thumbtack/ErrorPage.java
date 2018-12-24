package thumbtack;

import java.util.*;

public class ErrorPage {

    /*
    global results list
    func: findErrorPages return if the current node is error page or not
    for each node
        call findErrorPages on all of the child
        if any of the child returns true(i.e. child is error page), add current node to results, and return true
        otherwise, return false
     */

    List<GraphNode> errorpages(List<GraphNode> graph, Set<GraphNode> errorNodes) {
        List<GraphNode> results = new ArrayList<>();
        results.addAll(errorNodes);
        Map<GraphNode, Boolean> cache = new HashMap<>();
        for (GraphNode node : graph) {
            findErrors(node, errorNodes, new ArrayList<>(), cache, results);
        }
        return results;
    }

    // return if the current node is error
    private boolean findErrors(GraphNode cur, Set<GraphNode> errorNodes, List<GraphNode> path,
                               Map<GraphNode, Boolean> cache, List<GraphNode> results) {
        if (cache.containsKey(cur)) {
            return cache.get(cur);
        }
        if (errorNodes.contains(cur)) {
            return true;
        }
        boolean isError = false;
        for (GraphNode neighbor : cur.neighbors) {
            path.add(neighbor);
            boolean neighborIsError = findErrors(neighbor, errorNodes, path, cache, results);
            path.remove(path.size() - 1);
            isError = isError || neighborIsError;
        }
        cache.put(cur, isError);
        if (isError) {
            results.add(cur);
        }
        return isError;
    }
}
