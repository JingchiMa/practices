package strengthenV;


import java.util.ArrayDeque;
import java.util.Deque;

public class MaxHistogram {

    public int maxHistogram(int[] heights) {
        int[] leftBounds = new int[heights.length]; // inclusive
        leftBounds[0] = 0;
        int[] rightBounds = new int[heights.length]; // inclusive
        rightBounds[heights.length - 1] = heights.length - 1;

        // calculate right bounds
        Deque<Integer> stack = new ArrayDeque<>(); // stores the indices of height who we still didn’t know the right bound
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] > heights[i]) {
                rightBounds[stack.pollFirst()] = i - 1;
            }
            stack.offerFirst(i);
        }
        while (!stack.isEmpty()) {
            rightBounds[stack.pollFirst()] = heights.length - 1;
        }

        // calculate the left bounds
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] > heights[i]) {
                leftBounds[stack.pollFirst()] = i + 1;
            }
            stack.offerFirst(i);
        }
        while (!stack.isEmpty()) {
            leftBounds[stack.pollFirst()] = 0;
        }

        int maxArea = 0;

// find the maximum
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (rightBounds[i] - leftBounds[i] + 1) * heights[i]);
        }
        return maxArea;
    }

}
