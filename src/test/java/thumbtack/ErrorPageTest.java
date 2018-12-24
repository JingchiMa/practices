package thumbtack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ErrorPageTest {
    @Test
    public void errorpages() throws Exception {
        ErrorPage instance = new ErrorPage();
        List<GraphNode> graph = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            graph.add(new GraphNode(i));
        }
        graph.get(2).neighbors.add(graph.get(1));
        graph.get(1).neighbors.add(graph.get(2));
        graph.get(1).neighbors.add(graph.get(7));
        graph.get(1).neighbors.add(graph.get(4));
        graph.get(3).neighbors.add(graph.get(1));
        graph.get(4).neighbors.add(graph.get(6));
        graph.get(5).neighbors.add(graph.get(4));
        graph.get(0).neighbors.add(graph.get(6));

        Set<GraphNode> errorNodes = new HashSet<>();
        errorNodes.add(graph.get(7));
        errorNodes.add(graph.get(5));
        System.out.println(instance.errorpages(graph, errorNodes));
    }

}