package strengthenIV;

import java.util.*;

public class FourSum {

    public boolean fourSum(int[] nums, int target) {
        // 2sum -> the min last index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer lastIndex = map.get(nums[i] + nums[j]);
                if (lastIndex == null || lastIndex > j) {
                    map.put(nums[i] + nums[j], j);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer lastIndex = map.get(target - (nums[i] + nums[j]));
                if (lastIndex != null && lastIndex < i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fourSumII(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer lastIndex = map.get(target - nums[i] - nums[j]);
                if (lastIndex == null || lastIndex < i) {
                    return true;
                }
                Integer curSumLastIndex = map.get(nums[i] + nums[j]);
                if (curSumLastIndex == null || curSumLastIndex > j) {
                    map.put(nums[i] + nums[j], j);
                }
            }
        }
        return false;
    }

    public int fourSumNumber(int[] nums, int target) {
        Arrays.sort(nums);
        // step 1:
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 1; j < nums.length; j++) {
//            if (j != 1 && nums[j] == nums[j-1]) {这样去重是错误的
//                continue;
//            }
//            if (j != nums.length - 1 && nums[j] == nums[j + 1]) { 这样也不对
//                continue;
//            }
            if (j != 1 && nums[j] == nums[j-1]) {
                if (nums[j-1] != nums[j-2]) {
                    map.putIfAbsent(nums[j-1] + nums[j], new ArrayList<>());
                    map.get(nums[j-1] + nums[j]).add(j);
                }
                continue;
            }
            for (int i = 0; i < j; i++) {
                if (i != 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(j); // this way the last index is guaranteed to be in ascending order
            }
        }

        // step 2:
        int count = 0;
        for (int j = nums.length - 1; j > 0; j--) {
            if (j != nums.length - 1 && nums[j] == nums[j+1]) {
                continue;
            }
            for (int i = j-1; i >= 0; i--) {
                if (i != j-1 && nums[i] == nums[i+1]) {
                    continue;
                }
                List<Integer> indices = map.get(target - nums[j] - nums[i]);
                if (indices != null) {
                    count += (binarySearch(indices, i) + 1);
                }
            }
        }
        return count;
    }

    // return the index of the last element which is strictly smaller than the target
    private int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums.get(mid) < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums.get(left) < target) {
            return left;
        }
        return -1;
    }


}
