package interviews.AppDynamics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterFrequency {

    List<Integer> frequencies(String s) {
        int[] indices = new int[26];
        Arrays.fill(indices, -1);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx] < 0) {
                results.add(1);
                indices[idx] = results.size() - 1;
            } else {
                results.set(indices[idx], results.get(indices[idx]) + 1);
            }
        }
        return results;
    }

}
