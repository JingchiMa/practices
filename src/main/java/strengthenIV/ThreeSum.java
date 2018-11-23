package strengthenIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] input, int target) {
        Arrays.sort(input);
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < input.length - 2; i++) {
            if (i != 0 && input[i] == input[i-1]) {
                continue;
            }
            List<List<Integer>> twoSums = twoSum(input, i+1, target - input[i]);
            for (List<Integer> twoSum : twoSums) {
                twoSum.add(input[i]);
            }
            results.addAll(twoSums);
        }
        return results;
    }

    // return the distinct pair
    private List<List<Integer>> twoSum(int[] input, int start, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int end = input.length - 1;
        while (start < end) {
            if (input[start] + input[end] < target) {
                start++;
            } else if (input[start] + input[end] == target) {
                results.add(new ArrayList<>(Arrays.asList(input[start], input[end])));
                start++;
                end--;
                while (start < end && input[start] == input[start-1]) {
                    start++;
                }
                while (start < end && input[end] == input[end+1]) {
                    end--;
                }
            } else {
                end--;
            }

        }
        return results;
    }
}
