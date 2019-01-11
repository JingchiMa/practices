package interviews.Houzz;

public class LocalMinimum {

    int localMinimum(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i-1] && nums[i] < nums[i+1]) {
                return i;
            }
        }
        return -1; // no minimum;
    }

    int localMinimumII(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                return mid;
            } else if (nums[mid] < nums[mid-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // not found, shouldn't be reached
    }

}
