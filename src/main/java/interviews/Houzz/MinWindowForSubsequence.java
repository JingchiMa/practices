package interviews.Houzz;

import java.util.*;

public class MinWindowForSubsequence {
    public String minWindow(String s, String t) {
        /*
        Brute force: O(n ^ 2 * n) = O(n^3)

        S = adbde
        W = bcd
        T = bd

        [left, right) => Map<character, index in S>   Map<index in s, character>
        S: a  b  c  d  e
           LR

        T: bd

        Data Structure:
            left: the left boundary of sliding window in S (inclusive)
            right:     right ... (exclusive)
            left, right = 0

            pt: the index of character in t to be matched next
            pt = 0

            S = abac // property: there must exist a subsequence = T
                   |
            T = abc
                  |
            a -> 0, 2
            b -> 1
            c -> 3

            S = ababc
                    |
            T = abc
                 |
            a -> 0, 2
            b -> 1, 3
            c -> 4

            find the shortest increasing subsequence -> DP

            Map<character in T, List<Index in S>>: valid index -> the characters
            List<List<
        Algorithm:
            while right < s.length()

        T: t_index: the character to be matched
        */

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int left = 0; // todo: the first occurrence of t.charAt(0)
        int right = 0;
        int pt = 0;
        Map<Character, List<Integer>> indices = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = -1; // inclusive
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                indices.putIfAbsent(s.charAt(right), new ArrayList<>());
                indices.get(s.charAt(right)).add(right);
                if (s.charAt(right) == t.charAt(pt)) {
                    pt++;
                }
            }
            if (pt == t.length()) {
                int prev = right;
                for (int i = pt-2; i >= 0; i--) {
                    prev = binarySearch(indices.get(t.charAt(i)), prev);
                }
                if (right - prev + 1 < minLen) {
                    minLen = right - prev + 1;
                    start = prev;
                    end = right;
                }
                left = prev + 1;
                for (int i = 0; i < t.length(); i++) {
                    List<Integer> indexList = indices.get(t.charAt(i));
                    int nextLeft = minLarger(indexList, left);
                    if (nextLeft < 0) {
                        pt = i;
                        break;
                    }
                    left = nextLeft + 1;
                }
            }
            right++;
        }
        return s.substring(start, end + 1);
    }

    // return the largest number that is striclty smaller than target
    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return list.get(left); // always exist such a number
    }

    // return the minimum number that is larger than or equal to the target
    private int minLarger(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left) >= target ? list.get(left) : -1;
    }

    public String minimumSubstring(String s, String t) {
        int left = 0;
        int right = 0;
        int pt = 0;
        int min = Integer.MAX_VALUE;
        int globalLeft = 0;
        int globalRight = 0;
        while (right < s.length()) {
            if (s.charAt(right) == t.charAt(pt)) {
                pt++;
            }
            if (pt == t.length()) { // valid solution
                int start = right;
                pt--;
                while (pt >= 0) {
                    if (s.charAt(start) == t.charAt(pt)) {
                        pt--;
                    }
                    start--;
                }
                pt = 0;
                start++; // [start, right]
                if (right - start + 1 < min) {
                    min = right - start + 1;
                    globalLeft = start;
                    globalRight = right + 1;
                }
                left = start + 1;
            }
            right++;
        }
        return s.substring(globalLeft, globalRight);
    }

}
