package midtermReview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberArrangements {

    // method I: permutation
    // assumptions: nums is in the form of {1, 1, 2, 2, … }
    public List<Integer> arrangement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        dfs(0, nums, new HashMap<>(), new ArrayList<>(), result);
        return result;
    }

    private void dfs(int index, int[] inputs, Map<Integer, Integer> indices, List<Integer> path, List<Integer> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (index == inputs.length) {
            result.addAll(path);
            return;
        }
        for (int i = index; i < inputs.length; i++) {
            swap(inputs, i, index);
            Integer prevIndex = indices.get(inputs[index]);
            if (prevIndex == null || index - prevIndex - 1 == inputs[index]) {
                if (prevIndex == null) {
                    indices.put(inputs[index], index);
                }
                path.add(inputs[index]);
                dfs(index + 1, inputs, indices, path, result);
                path.remove(path.size() - 1);
                if (prevIndex == null) {
                    indices.remove(inputs[index]);
                }
            }
            swap(inputs, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // Method II: num placement
    // assumption: nums = {1, 1, 2, 2, … } have length >= 2
    public List<Integer> numArrange(int[] nums) {
        List<Integer> result = new ArrayList<>();
        dfs(0, nums, new int[nums.length], result);
        return result;
    }

    private void dfs(int index, int[] nums, int[] sequence, List<Integer> result) {
        if (!result.isEmpty()) {
            return;
        }
        if (index == nums.length) {
            for (int num : sequence) {
                result.add(num);
            }
            return;
        }
        for (int i = 0; i < nums.length - nums[index] - 1; i++) {
            if (sequence[i] == 0 && sequence[i + nums[index] + 1] == 0) {
                sequence[i] = nums[index];
                sequence[i + nums[index] + 1] = nums[index];
                dfs(index + 2, nums, sequence, result);
                sequence[i] = 0;
                sequence[i + nums[index] + 1] = 0;
            }
        }
    }


}
