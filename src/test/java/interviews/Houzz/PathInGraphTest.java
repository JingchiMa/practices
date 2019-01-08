package interviews.Houzz;

import org.junit.Test;
import utils.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PathInGraphTest {
    @Test
    public void allPaths() throws Exception {
        PathInGraph instance = new PathInGraph();
        int[][] input = {{1, 2}, {3}, {3, 4}, {5}, {5}, {}};
        Map<Integer, GraphNode> map = GraphNode.buildGraph(input);
        List<GraphNode> graph = new ArrayList<>();
        graph.addAll(map.values());
        System.out.println(instance.allPaths(graph, map.get(0), map.get(5), 4));
    }

    @Test
    public void pathNums() throws Exception {
        PathInGraph instance = new PathInGraph();
        int[][] input = {{1, 2}, {3}, {3, 4}, {5}, {5}, {}};
        Map<Integer, GraphNode> map = GraphNode.buildGraph(input);
        System.out.println(instance.pathNum(map.get(0), map.get(5), 4));
    }

    @Test
    public void pathNumsII() throws Exception {
        PathInGraph instance = new PathInGraph();
        int[][] input = {{1, 2}, {3}, {3, 4}, {5}, {5}, {}};
        Map<Integer, GraphNode> map = GraphNode.buildGraph(input);
        System.out.println(instance.pathNum(map.get(2), map.get(5), 3));
    }

    @Test
    public void pathNumsIITest2() throws Exception {
        PathInGraph instance = new PathInGraph();
        int[][] input = {{1, 2}, {3}, {3, 4}, {5}, {5}, {}};
        Map<Integer, GraphNode> map = GraphNode.buildGraph(input);
        System.out.println(instance.pathNum(map.get(2), map.get(5), 3));
    }


}