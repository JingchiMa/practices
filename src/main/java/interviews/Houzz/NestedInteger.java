package interviews.Houzz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class NestedInteger {

    private boolean isInteger;
    private Integer val;
    private List<NestedInteger> list = new ArrayList<>();

    NestedInteger(int val) {
        this.val = val;
        this.isInteger = true;
    }

    NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.isInteger = false;
    }

    public boolean isInteger() {
        return this.isInteger;
    }

    public Integer getInteger() {
        return this.val;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }

    @Override
    public String toString() {
        if (this.isInteger()) {
            return this.getInteger() + "";
        } else {
            return this.getList().toString();
        }
    }

    public static List<NestedInteger> nestedIntegers(String input) {
        return nestedIntegers(input, 0, input.length() - 1);
    }

    // invariant: input[start] and input[end] are '[' and ']' respectively
    // 忘记考虑负数了！
    private static List<NestedInteger> nestedIntegers(String input, int start, int end) {
        List<NestedInteger> results = new ArrayList<>();
        int i = start + 1;
        while (i < end) {
            char cur = input.charAt(i);
            if (Character.isDigit(cur)) {
                int num = 0;
                while (i < end && Character.isDigit(input.charAt(i))) {
                    num = num * 10 + cur - '0';
                    i++;
                }
                results.add(new NestedInteger(num));
            } else if (cur == '[') {
                int left = 0;
                int leftIdx = i;
                do {
                    if (input.charAt(i) == '[') {
                        left++;
                    } else if (input.charAt(i) == ']') {
                        left--;
                    }
                    i++;
                } while (i < end && left > 0);
                results.add(new NestedInteger(nestedIntegers(input, leftIdx, i)));
            }
            i++;
        }
        return results;
    }

    // iterative way
    /*
    Assumptions:
    (1) input is always valid [1, 2, [1,2], [3, 4,5]]]
    (2) numbers can be negative
     */
    public static List<NestedInteger> build(String s) {
        Deque<List<NestedInteger>> stack = new ArrayDeque<>();
        List<NestedInteger> curList = new ArrayList<>();
        int i = 1;
        while (i < s.length() - 1) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur) || cur == '-' || cur == '+') {
                int sign = cur == '-' ? -1 : 1;
                int num = Character.isDigit(cur) ? cur - '0' : 0;
                i++;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                curList.add(new NestedInteger(num * sign));
            } else if (cur == '[') {
                stack.offerFirst(curList);
                curList = new ArrayList<>();
            } else if (cur == ']') {
                NestedInteger node = new NestedInteger(curList);
                curList = stack.pollFirst();
                curList.add(node);
            }
            i++;
        }
        return curList;
    }
}
