package interviews.Houzz;

import java.util.*;
public class Calculator {
    public int calculate(String s) {
        /*
        Stack<String> stack: stores the expression awaiting to be evaluated
        case I: seen a '('
            if ')', then evaluate
            else, offer into stack
        case II: haven't seen a '(' -> in the stack there's no '('
            direct evaluate
        */

        int open = 0;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = s.charAt(i) + "";
            if (isParentheses(cur)) {
                switch (cur) {
                    case "(":
                        stack.offerFirst(cur);
                        break;
                    case ")":
                        evaluate(stack);
                        break;
                }
            } else if (isOperator(cur)) {
                stack.offerFirst(cur);
            } else if (isNumber(cur)) {
                int num = 0;
                while (i < s.length() && isNumber(s.charAt(i) + "")) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                stack.offerFirst(num + "");
            }
        }
        System.out.println(stack);
        evaluate(stack);
        return Integer.parseInt(stack.pop());
    }

    // evaluate the expression until hit a '(' or the stack is empty
    private void evaluate(Deque<String> stack) {
        Deque<String> buffer = new ArrayDeque<>();
        while (!stack.isEmpty() && !stack.peekFirst().equals("(")) {
            String cur = stack.pollFirst();
            if (isOperator(cur)) {
                buffer.offerFirst(cur);
            } else {
                if (!buffer.isEmpty()) {
                    switch(buffer.peekFirst()) {
                        case "*":
                            buffer.pollFirst();
                            buffer.offerFirst(Integer.parseInt(cur) * Integer.parseInt(buffer.pollFirst()) + "");
                            break;
                        case "/":
                            buffer.pollFirst();
                            buffer.offerFirst(Integer.parseInt(cur) / Integer.parseInt(buffer.pollFirst()) + "");
                            break;
                        default:
                            buffer.offerFirst(cur);
                    }
                } else {
                    buffer.offerFirst(cur);
                }
            }
        }
        if (!stack.isEmpty()) {
            stack.pollFirst();
        }
        int res = Integer.parseInt(buffer.pollFirst());
        while (!buffer.isEmpty()) {
            switch(buffer.pollFirst()) {
                case "+":
                    res += Integer.parseInt(buffer.pollFirst());
                    break;
                case "-":
                    res -= Integer.parseInt(buffer.pollFirst());
                    break;
            }
        }
        stack.offerFirst(res + "");
    }

    private boolean isParentheses(String cur) {
        return cur.equals("(") || cur.equals(")");
    }

    private boolean isOperator(String cur) {
        return cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/");
    }

    private boolean isNumber(String cur) {
        return cur.charAt(0) >= '0' && cur.charAt(0) <= '9';
    }


    private static final int add = 1;
    private static final int subtract = 2;
    private static final int multiply = 3;
    private static final int divide = 4;

    public int calculateII(String s) {
        /*

        */

        // default
        int res = 0;
        int op1 = add;
        int subRes = 1;
        int op2 = multiply;

        Deque<Integer> plusStack = new ArrayDeque<>();
        Deque<Integer> multiplyStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '+' || cur == '-') {
                res = op1 == add ? res + subRes : res - subRes;
                op1 = cur == '+' ? add : subtract;
            } else if (cur == '*' || cur == '/') {
                op2 = cur == '*' ? multiply : divide;
            } else if (Character.isDigit(cur)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                subRes = op2 == multiply ? subRes * num : subRes / num;
            } else if (cur == '(') {
                plusStack.offerFirst(res);
                plusStack.offerFirst(op1);
                multiplyStack.offerFirst(subRes);
                multiplyStack.offerFirst(op2);
                res = 0;
                op1 = add;
                subRes = 1;
                op2 = multiply;
            } else if (cur == ')') {
                res = op1 == add ? res + subRes : res - subRes;
                int curResult = res;
                op1 = plusStack.pollFirst();
                res = plusStack.pollFirst();
                op2 = multiplyStack.pollFirst();
                subRes = op2 == multiply ? multiplyStack.pollFirst() * curResult : multiplyStack.pollFirst() / curResult;
            }
        }
        return op1 == add ? res + subRes : res - subRes;
    }
}
