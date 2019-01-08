package interviews.Houzz;

import java.util.*;

public class LargestKNumbersInString {

    // assumption: only consider integer in the string
    List<Integer> largestK(String input, int k) {
        if (k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isNegative = false;
        boolean seenNumber = false;
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (Character.isDigit(cur)) {
                seenNumber = true;
                num = num * 10 + cur - '0';
            } else if (cur == '-') {
                isNegative = true;
            } else {
                if (seenNumber) {
                    int curNum = isNegative ? -num : num;
                    addToHeap(minHeap, curNum, k);
                }
                // reset
                isNegative = false;
                seenNumber = false;
                num = 0;
            }
        }
        if (seenNumber) {
            int curNum = isNegative ? -num : num;
            addToHeap(minHeap, curNum, k);
        }
        List<Integer> results = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            results.add(minHeap.poll());
        }
        Collections.reverse(results);
        return results;
    }

    private void addToHeap(PriorityQueue<Integer> minHeap, int curNum, int k) {
        if (minHeap.size() < k) {
            minHeap.offer(curNum);
        } else if (minHeap.peek() < curNum) {
            minHeap.poll();
            minHeap.offer(curNum);
        }
    }



}
