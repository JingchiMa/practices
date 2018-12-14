package strengthenI;

import java.util.Arrays;

public class DeduplicationInArray {

    // keep one copy for the duplicate numbers
    int[] deduplicateI(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (slow <= 1 || nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return Arrays.copyOfRange(nums, 0, slow); // slow is exclusive
    }

    // keep no copy for duplicate numbers
    // 2 3 2 3 3 3
    //   s
    //             f

    int[] deduplicateII(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (slow > 0 && nums[slow-1] == nums[fast]) {
                while (fast < nums.length && nums[slow-1] == nums[fast]) {
                    fast++;
                }
                slow--;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return Arrays.copyOfRange(nums, 0, slow);
    }

    int[] recursivelyDeduplicate(int[] nums) {
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (slow > 0 && nums[slow-1] == nums[fast]) {
                while (fast < nums.length && nums[slow-1] == nums[fast]) {
                    fast++;
                }
                slow--;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return Arrays.copyOfRange(nums, 0, slow);
    }

    void pushBackZeros(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }



}
