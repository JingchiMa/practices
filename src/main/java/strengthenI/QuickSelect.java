package strengthenI;

public class QuickSelect {

    public int kthLargestElement(int n, int[] nums) {
        return helper(nums, 0, nums.length - 1, n);
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k <= (right - start + 1)) {
            return helper(nums, start, right, k);
        } else if (k > (left - start)) {
            return helper(nums, left, end, k - (left - start));
        } else {
            return nums[right + 1];
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
