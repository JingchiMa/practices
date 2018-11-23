package strengthenIV;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidParentheses {

    public List<String> validParentheses(int[] numbers) {
        List<String> results = new ArrayList<>();
        int n = numbers.length;
        char[] openParentheses = {'(', '[', '{'};
        char[] closeParentheses = {')', ']', '}'};
        dfs(new int[n], new int[n], numbers, openParentheses, closeParentheses, new ArrayDeque<>(), new StringBuilder(), results);
        return results;
    }

    private void dfs(int[] opens, int[] closes, int[] numbers,
                     char[] openParentheses, char[] closeParentheses,
                     Deque<Integer> stack, StringBuilder path, List<String> results) {
        if (hasEnded(opens, closes, numbers)) {
            results.add(path.toString());
            return;
        }
        for (int i = 0; i < opens.length; i++) {
            if (opens[i] < numbers[i] && (stack.isEmpty() || i <= stack.peekFirst())) {
                path.append(openParentheses[i]);
                stack.offerFirst(i);
                opens[i]++;
                dfs(opens, closes, numbers, openParentheses, closeParentheses, stack, path, results);
                path.deleteCharAt(path.length() - 1);
                stack.pollFirst();
                opens[i]--;
            }
        }
        for (int i = 0; i < closes.length; i++) {
            if (closes[i] < opens[i] && i == stack.peekFirst()) {
                path.append(closeParentheses[i]);
                stack.pollFirst();
                closes[i]++;
                dfs(opens, closes, numbers, openParentheses, closeParentheses, stack, path, results);
                path.deleteCharAt(path.length() - 1);
                stack.offerFirst(i);
                closes[i]--;
            }
        }
    }

    private boolean hasEnded(int[] opens, int[] closes, int[] numbers) {
        for (int i = 0; i < opens.length; i++) {
            if (opens[i] != closes[i] || opens[i] != numbers[i]) {
                return false;
            }
        }
        return true;
    }

}
