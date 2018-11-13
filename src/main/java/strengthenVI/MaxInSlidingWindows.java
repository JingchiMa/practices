package strengthenVI;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxInSlidingWindows {

    public int[] maxsInSlidingWindows(int[] nums, int k) {
        int[] maxs = new int[nums.length - k + 1];
        int resultIdx = 0 - (k-1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (deque.peekFirst() <= i-k) {
                    deque.pollFirst();
                }
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (resultIdx >= 0) {
                maxs[resultIdx] = nums[deque.peekFirst()];
            }
            resultIdx++;
        }
        return maxs;
    }

    public int[] maxsInSlidingWindowsII(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nums[a] - nums[b];
            }
        }.reversed());
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (i >= k - 1) {
                while (pq.peek() <= i - k) {
                    pq.poll(); // invalid anymore
                }
                res[i - (k-1)] = pq.peek();
            }
        }
        return res;
    }


}
