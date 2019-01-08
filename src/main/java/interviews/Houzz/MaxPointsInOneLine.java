package interviews.Houzz;

import java.util.*;

public class MaxPointsInOneLine {

    List<Double> maxPointsLine(List<List<Integer>> points) {
        Map<List<Double>, Set<List<Integer>>> map = new HashMap<>();
        int max = 0;
        List<Double> maxLine = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                List<Double> line = getLine(points.get(i), points.get(j));
                map.putIfAbsent(line, new HashSet<>());
                Set<List<Integer>> curPoints = map.get(line);
                curPoints.add(points.get(i));
                curPoints.add(points.get(j));
                if (curPoints.size() > max) {
                    max = curPoints.size();
                    maxLine = line;
                }
            }
        }
        return maxLine;
    }

    private List<Double> getLine(List<Integer> point1, List<Integer> point2) {
        if (point1.get(0).equals(point2.get(0))) {
            return new ArrayList<>(Collections.singletonList(point1.get(0) * 1.0));
        }
        double k = (point1.get(1) - point2.get(1)) / (point1.get(0) - point2.get(0));
        double b = point1.get(1) - k * point1.get(0);
        return new ArrayList<>(Arrays.asList(k, b));
    }

}
