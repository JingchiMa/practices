package interviews.Houzz;

import java.util.*;

public class RandomKeysInHashMap {
    // assumptions: (1) all the values are non-negative integers

    String randomPrint(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>();
        entries.addAll(map.entrySet());
        int[] prefixSums = new int[entries.size()];
        for (int i = 1; i < entries.size(); i++) {
            prefixSums[i] = prefixSums[i-1] + entries.get(i - 1).getValue();
        }
        int sum = prefixSums[entries.size() - 1] + entries.get(entries.size() - 1).getValue();
        int random = (int) (Math.random() * sum);
        int index = binarySearch(prefixSums, random);
        return entries.get(index).getKey();
    }

    // return the max index of numbers that is smaller than or equal to the target
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
