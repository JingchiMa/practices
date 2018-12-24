package thumbtack;

import java.util.*;

public class SmallestRange {
    // assume: input not null or empty, and each list in the nums is not null or empty
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.isEmpty()) {
            return new int[0];
        }
        /*
        PriorityQueue pq (minheap): stores the one number from each list
        maintain a max variable
        each time
            poll out the min, and offer the next one
            [min, max]
        when to stop: when the min have no next
        [min, max] max
        */

        // int[0] list number, int[1] the index of the number in the list
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                int num1 = nums.get(pair1[0]).get(pair1[1]);
                int num2 = nums.get(pair2[0]).get(pair2[1]);
                return num1 - num2; // can overflow
            }
        });
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = Integer.MAX_VALUE; // vulnerable to overflow
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            pq.offer(new int[] {i, 0});
        }
        while (!pq.isEmpty()) {
            int[] minPair = pq.poll();
            int min = nums.get(minPair[0]).get(minPair[1]);
            if (max - min < right - left) {
                left = min;
                right = max;
            }
            if (minPair[1] + 1 >= nums.get(minPair[0]).size()) {
                break;
            } else {
                max = Math.max(max, nums.get(minPair[0]).get(minPair[1] + 1));
                pq.offer(new int[] {minPair[0], minPair[1] + 1});
            }
        }
        return new int[] {left, right};
    }
}
