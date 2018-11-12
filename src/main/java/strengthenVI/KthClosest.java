package strengthenVI;

public class KthClosest {
    // return value = [start, end] for the k closest elements
    public int[] kClosest(int[] nums, int target, int k) {
        int index = getClosest(nums, target);
        if (k == 1) {
            return new int[] {index, index};
        }
        int[] res = kElements(nums, index - 1, index + 1, k - 1, -1, -1, target);
        if (res[0] == -1) {
            res[0] = index;
        }
        if (res[1] == -1) {
            res[1] = index;
        }
        return res;
    }

    // return the two indices
    // left is the start for left part
    // right is the start for right part
    // k is the number of elements to find
    // prevLeft = the previous index for left part
    private int[] kElements(int[] nums, int left, int right, int k, int prevLeft, int prevRight, int target) {
        if (k == 1) {
            if (left >= 0 && (right >= nums.length || target - nums[left] <= nums[right] - target)) {
                return new int[] {left, prevRight};
            } else {
                return new int[] {prevLeft, right};
            }
        }
        int leftIndex = left - k / 2 + 1;
        int rightIndex = right + k / 2 - 1;
        if (leftIndex >= 0 && (right >= nums.length || target - nums[leftIndex] <= nums[rightIndex] - target)) {
            return kElements(nums, leftIndex - 1, right, k - k / 2, leftIndex, prevRight, target);
        } else {
            return kElements(nums, left, rightIndex + 1, k - k / 2, prevLeft, rightIndex, target);
        }
    }

    // return the index of the element which is closest to target
    private int getClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                left = mid;
            }
        }
        return target - nums[left] <= nums[right] - target ? left : right;
    }

}
