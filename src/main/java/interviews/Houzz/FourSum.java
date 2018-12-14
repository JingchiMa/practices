package interviews.Houzz;

import java.util.*;
public class FourSum {
    // Find # of unique quadruplets that sum to a target

    int fourSumNums(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new TreeSet<>());
                }
                map.get(sum).add(j);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                TreeSet<Integer> indices = map.get(target - sum);
                if (indices != null) {
                    count += indices.headSet(i).size();
                }
            }
        }
        return count;
    }
}
