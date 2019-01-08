package leetcodes;

import java.util.*;

public class LongestConsecutiveSequence {

    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public int longestConsecutive(int[] nums) {
        // Map<Number, Interval> map
        /*
        for each num
            get the intervals for num + 1 and num - 1
            merge the two intervals with num
            put num and merged intervals into map
            update the max
        */

        int max = 0;
        Map<Integer, Interval> map = new HashMap<>();
        for (int num : nums) {
            Interval interval1 = map.get(num - 1);
            Interval interval2 = map.get(num + 1);
            Interval merged = merge(interval1, interval2, num);
            map.put(num, merged);
            if (interval1 != null) {
                map.put(num - 1, merged);
            }
            if (interval2 != null) {
                map.put(num + 1, merged);
            }
            max = Math.max(max, merged.end - merged.start + 1);
            System.out.println(merged.start + " " + merged.end);
        }
        return max;
    }

    // interval1, num, interval2
    private Interval merge(Interval interval1, Interval interval2, int num) {
        if (interval1 == null && interval2 == null) {
            return new Interval(num, num);
        }
        if (interval1 == null) {
            interval2.start = Math.min(interval2.start, num);
            return interval2;
        }
        if (interval2 == null) {
            interval1.end = Math.max(interval1.end, num);
            return interval1;
        }
        return new Interval(interval1.start, interval2.end);
    }
}