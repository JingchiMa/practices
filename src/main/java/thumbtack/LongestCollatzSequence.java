package thumbtack;

import java.util.HashMap;
import java.util.Map;

public class LongestCollatzSequence {
    // assumption: n >= 1
    public int longestCollatzSequence(int n) {
        int[] max = new int[1];
        sequenceLength(n, new HashMap<>(), max);
        return max[0];
    }

    // return the sequence length for n
// the cache stores num -> sequence length
    int sequenceLength(int num, Map<Integer, Integer> cache, int[] max) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        if (num == 1) {
            return 0;
        }
        int length = 1;
        if (num % 2 == 1) {
            length += sequenceLength(3 * num + 1, cache, max);
        } else {
            length += sequenceLength(num / 2, cache, max);
        }
        max[0] = Math.max(max[0], length);
        return length;
    }

}
