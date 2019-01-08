package strengthenI;

public class WiggleSortII {
    private int[] nums;

    public void wiggleSort(int[] nums) {
        this.nums = nums;
        double mid = findMid(nums);
        System.out.println(mid);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < right;) {
            int realI = getIndex(i);
            int realLeft = getIndex(left);
            int realRight = getIndex(right);

            if (nums[realI] > mid) {
                swap(nums, realI, realLeft);
                left++;
                i++;
            } else if (nums[realI] < mid) {
                swap(nums, realI, realRight);
                right--;
            } else {
                i++;
            }
        }
    }

    private int getIndex(int virtualIdx) {
        int evenStart = nums.length / 2;
        if (virtualIdx >= evenStart) {
            return (virtualIdx - nums.length / 2) * 2;
        } else {
            return 2 * virtualIdx + 1;
        }
    }

    private double findMid(int[] nums) {
        if (nums.length % 2 == 0) {
            return (findKth(nums, 0, nums.length - 1, nums.length / 2) + findKth(nums, 0, nums.length - 1, nums.length / 2 + 1)) / 2.0;
        } else {
            return findKth(nums, 0, nums.length - 1, (nums.length + 1) / 2);
        }
    }

    private int findKth(int[] nums, int start, int end, int k) {
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
            return findKth(nums, start, right, k);
        } else if (k > (left - start)) {
            return findKth(nums, left, end, k - (left - start));
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
