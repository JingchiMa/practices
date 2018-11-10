package thumbtack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReflectedPoints {

    public boolean isReflected(int[][] points) {
        // step 1: store all points in the set, and get the sum
        // sum will be equal to min {x} + max {x}

        Set<List<Integer>> set = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            set.add(toList(point));
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
        }
        int sum = minX + maxX;

        // step 2: for each point, check if the pair point is in the set

        for (int[] point : points) {
            List<Integer> pairPoint = new ArrayList<>();
            pairPoint.add(sum - point[0]);
            pairPoint.add(point[1]);
            if (!set.contains(pairPoint)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> toList(int[] point) {
        List<Integer> pointList = new ArrayList<>();
        pointList.add(point[0]);
        pointList.add(point[1]);
        return pointList;
    }
}
