package interviews.Houzz;

import java.util.*;

public class CollatzConjecture {

    int findLongestSequence(int n) {
        int max = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, helperII(i, cache));
        }
        return max;
    }

    private int helper(int start, Map<Integer, Integer> cache) {
        if (start == 1) {
            return 1;
        }
        if (cache.containsKey(start)) {
            return cache.get(start);
        }
        int result;
        if (start % 2 == 0) {
            result = helper(start / 2, cache) + 1;
        } else {
            result = helper(start * 3 + 1, cache) + 1;
        }
        cache.put(start, result);
        return result;
    }

    private int helperII(int start, Map<Integer, Integer> cache) {
        if (start == 1) {
            return 1;
        }
        if (cache.containsKey(start)) {
            return cache.get(start);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        while (start != 1) {
            stack.offerFirst(start);
            if (start % 2 == 0) {
                start = start / 2;
            } else {
                start = start * 3 + 1;
            }
        }
        int len = 1;
        while (!stack.isEmpty()) {
            len++;
            cache.put(stack.pollFirst(), len);
        }
        return len;
    }


}
