package interviews.Houzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MaxPointsInOneLineTest {
    @Test
    public void maxPointsLine() throws Exception {
        MaxPointsInOneLine instance = new MaxPointsInOneLine();
        List<List<Integer>> points = new ArrayList<>();
        points.add(new ArrayList<>(Arrays.asList(1, 2)));
        points.add(new ArrayList<>(Arrays.asList(2, 4)));
        points.add(new ArrayList<>(Arrays.asList(3, 6)));
        points.add(new ArrayList<>(Arrays.asList(5, 8)));
        System.out.println(instance.maxPointsLine(points));
    }

}