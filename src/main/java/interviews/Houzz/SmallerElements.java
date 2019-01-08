package interviews.Houzz;

import java.util.*;

public class SmallerElements {
    int[] smallerElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]) {
                res[stack.pollFirst()] = nums[i];
            }
            stack.offerFirst(i);
        }
        return res;
    }

    int[] smallerElemenetsII(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peekFirst()]) {
                stack.pollFirst();
            }
            if (!stack.isEmpty()) {
                res[i] = nums[stack.peekFirst()];
            }
            stack.offerFirst(i);
        }
        return res;
    }

}
