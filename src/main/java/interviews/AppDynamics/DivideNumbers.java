package interviews.AppDynamics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivideNumbers {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // i1 -> num-1, i2 -> num+1
        public static Interval merge(Interval i1, Interval i2, int num) {
            if (i1 == null && i2 == null) {
                return new Interval(num, num);
            } else if (i1 == null) {
                i2.start = num;
                return i2;
            } else if (i2 == null) {
                i1.end = num;
                return i1;
            } else {
                return new Interval(i1.start, i2.end);
            }
        }
    }
    public List<List<Integer>> DivideIntoConsecutiveGroups(int[] nums) {

        Map<Integer, Interval> map = new HashMap<>();
        for (int num : nums) {
            Interval i1 = map.get(num-1);
            Interval i2 = map.get(num+1);
            Interval merged = Interval.merge(i1, i2, num);
            if (i1 != null) {
                map.put(num-1, merged);
            }
            if (i2 != null) {
                map.put(num+1, merged);
            }
            map.put(num, merged);
        }

        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int num : nums) {
            int groupId = map.get(num).start;
            List<Integer> group = groups.get(groupId);
            if (group == null) {
                group = new ArrayList<>();
                groups.put(groupId, group);
                results.add(group);
            }
            group.add(num);
        }
        return results;
    }

}
