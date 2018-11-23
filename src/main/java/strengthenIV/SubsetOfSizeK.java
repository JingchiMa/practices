package strengthenIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfSizeK {

    public List<List<Integer>> subsetOfSizeK(int[] nums, int k) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, 0, k, new ArrayList<>(), results);
        return results;
    }

    // 这样没有检验duplicate！！
    private void dfsII(int level, int[] nums, int numberChosen, int k, List<Integer> path, List<List<Integer>> results) {
        if (level == nums.length) {
            if (numberChosen == k) {
                results.add(new ArrayList<>(path));
            }
            return;
        }

        if (numberChosen < k) {
            path.add(nums[level]);
            dfs(level + 1, nums, numberChosen + 1, k, path, results);
            path.remove(path.size() - 1);
        }
        dfs(level + 1, nums, numberChosen, k, path, results);
    }

    private void dfs(int level, int[] nums, int numberChosen, int k, List<Integer> path, List<List<Integer>> results) {
        if (level == nums.length) {
            if (numberChosen == k) {
                results.add(new ArrayList<>(path));
            }
            return;
        }
        if (numberChosen < k) {
            path.add(nums[level]);
            dfs(level + 1, nums, numberChosen + 1, k, path, results);
            path.remove(path.size() - 1);
        }
        int nextLevel = level + 1;
        while (nextLevel < nums.length && nums[nextLevel] == nums[level]) {
            nextLevel++;
        }
        dfs(nextLevel, nums, numberChosen, k, path, results);
    }
}
