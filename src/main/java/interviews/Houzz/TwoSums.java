package interviews.Houzz;

import java.util.*;

public class TwoSums {
    // all distinct pairs
    List<List<Integer>> allPairs(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int num2 : nums) {
            int num1 = target - num2;
            int occur1 = map.getOrDefault(num1, 0);
            int occur2 = map.getOrDefault(num2, 0);
            if (occur2 >= 2 || occur2 == 1 && num1 != num2) {
                continue;
            }
            if (occur1 > 0) {
                results.add(new ArrayList<>(Arrays.asList(num1, num2)));
            }
            map.put(num2, occur2 + 1);
        }
        return results;
    }

    List<List<Integer>> allPairsMethodII(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                results.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return results;
    }

    // Follow-up: k sums

    // Assume k >= 1
    List<List<Integer>> kNumbers(int[] nums, int k, int target) {
        Arrays.sort(nums);
        return helper(nums, k, 0, target);
    }

    // start: inclusive
    private List<List<Integer>> helper(int[] nums, int k, int start, int target) {
        if (start >= nums.length) {
            return new ArrayList<>();
        }
        if (k == 1) {
            List<List<Integer>> results = new ArrayList<>();
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == target) {
                    results.add(new ArrayList<>(Collections.singletonList(nums[i])));
                }
            }
            return results;
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> subResults = helper(nums, k-1, i + 1, target - nums[i]);
            for (List<Integer> kNums : subResults) {
                kNums.add(nums[i]);
                results.add(kNums);
            }
        }
        return results;
    }



}
