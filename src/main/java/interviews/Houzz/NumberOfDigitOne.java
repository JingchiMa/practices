package interviews.Houzz;

import java.util.*;

public class NumberOfDigitOne {
    // this solution will give time limit exceed errors
    // time complexity O( k * log k * L)
    int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        PriorityQueue<String> minHeap = new PriorityQueue<String>(new Comparator<String>() {
            /* comparator:
            (1) Must use Integer.parseInt instead of compareTo, e.g. 12 and 2
            (2) if only of the the string starts with 0, then that string is larger (because it will have
            longer length in the future)
            (3) if both of them start or not start with 0, then directly compare the their integer values
            */
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    if (s1.charAt(0) == '0' && s2.charAt(0) == '0'
                            || s1.charAt(0) != '0' && s2.charAt(0) != '0') {
                        return Integer.parseInt(s1) - Integer.parseInt(s2);
                    } else {
                        return s1.charAt(0) == '0' ? 1 : -1;
                    }
                } else {
                    return s1.length() - s2.length();
                }
            }
        });
        minHeap.offer("1");
        int res = 0;
        Set<String> set = new HashSet<>();
        set.add("1");
        while (!minHeap.isEmpty()) {
            String cur = minHeap.poll();
            if (cur.charAt(0) != '0') {
                res += numberOfOnes(cur);
                for (int i = 0; i <= 9; i++) {
                    String next = cur + i;
                    if (set.add(next) && Integer.parseInt(next) <= n) {
                        minHeap.offer(next);
                    }
                }
            }
            boolean added = false;
            for (int i = 9; i >= 1; i--) {
                String next = i + cur;
                if (set.add(next) && Integer.parseInt(next) <= n) {
                    minHeap.offer(next);
                    added = true;
                }
            }
            if (added) {
                minHeap.offer(0 + cur);
            }
        }
        return res;
    }

    private int numberOfOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count += 1;
            }
        }
        return count;
    }

    public String countDigitOneII(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String curString = i + "";
            int curCount = 0;
            for (int j = 0; j < curString.length(); j++) {
                if (curString.charAt(j) == '1') {
                    curCount++;
                }
            }
            if (curCount >= 1) {
                sb.append('[').append(curString).append(",").append(curCount).append(']');
            }
        }
        return sb.toString();
    }
}
