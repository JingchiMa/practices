package strengthenIV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivideArrayIntoTwoParts {

    public List<Integer> twoPartsWithClosetSum(int[] nums) {
        List<Integer> results = new ArrayList<>();
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        target /= 2;
        dfs(0, nums, 0, target, new ArrayList<>(), results, new int[1]);
        return results;
    }

    private void dfs(int level, int[] nums, int sum, int target, List<Integer> path, List<Integer> results, int[] bestSum) {
        if (level == nums.length) {
            if (path.size() > 0 && path.size() < nums.length) {
                if (results.isEmpty() || Math.abs(sum - target) < Math.abs(bestSum[0] - target)) {
                    bestSum[0] = sum;
                    results.clear();
                    results.addAll(path);
                }
            }
            return;
        }
        dfs(level + 1, nums, sum, target, path, results, bestSum);
        path.add(nums[level]);
        dfs(level + 1, nums, sum + nums[level], target, path, results, bestSum);
        path.remove(path.size() - 1);
    }


    // assumption: nums[i] >= 1
    public List<Integer> closestSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        int[][] dp = new int[target + 1][nums.length];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Math.abs(nums[0] - i) < i ? nums[0] : 0;
            for (int j = 1; j < nums.length; j++) {
                int useJ = (i < nums[j] ? dp[0][j-1] : dp[i - nums[j]][j-1]) + nums[j];
                int notUseJ = dp[i][j-1];
                if (Math.abs(useJ - i) < Math.abs(notUseJ - i)) {
                    dp[i][j] = useJ;
                } else {
                    dp[i][j] = notUseJ;
                }
            }
        }
        List<Integer> results = new ArrayList<>();
        int i = target;
        int j = nums.length - 1;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i][j-1]) {
                results.add(nums[j]);
                i = i < nums[j] ? 0 : i - nums[j];
            }
            j--;
        }
        if (j == 0 && Math.abs(nums[0] - i) < i) {
            results.add(nums[0]);
        }
        Collections.reverse(results);
        return results;
    }

}
