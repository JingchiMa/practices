package strengthenIV;

import java.util.*;

public class FourSumFinal {

    public int fourSumNumber(int[] nums, int target) {
        Arrays.sort(nums);
        // step 1: iterate all possible 2nd 2sums
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = nums.length - 1; j >= 1; j--) {
            if (j != nums.length - 1 && nums[j] == nums[j + 1]) { // only choose the latter one to
                // 1. better for the first half (map stores the second half)
                // 2. better for i
                continue;
            }
            for (int i = j-1; i >= 0; i--) { //
                if (i != j-1 && nums[i] == nums[i+1]) {
                    continue;
                }
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(i); // 这里的i不是sorted的, 所以才出错了.
            }
        }

        // step 2: iterate through all possible first 2 sums
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i-1]) { // always choose the first one to give more choices for j
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != 0 && nums[j] != nums[j-1]) { // always choose the first one to give more choice for the 2nd half
                    continue;
                }
                List<Integer> indices = map.getOrDefault(target - nums[i] - nums[j], new ArrayList<>());
                count += (binarySearch(indices, j) + 1);
            }
        }
        return count;
    }

    // input nums is sorted descending
    // return the index of the last element which is strictly larger than the target
    // if no such element, -1
    private int binarySearch(List<Integer> nums, int target) { // edge case when nums.isEmpty()
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums.get(mid) > target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left <= right && nums.get(left) > target) {
            return left;
        }
        return -1;
    }
}
