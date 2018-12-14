package strengthenI;

import static utils.Display.display;

public class WiggleSort {

    public void oddEven(int[] nums, int median) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { // should it be left <= right ?
            while (left < right && nums[mappedIndex(left, n)] >= median) {
                left++;
            }
            while (left < right && nums[mappedIndex(right, n)] <= median) {
                right--;
            }
            if (left < right) {
                swap(nums, mappedIndex(left, n), mappedIndex(right, n));
                left++;
                right--;
            }
        }
    }

    public void oddEvenII(int[] nums, int median) {
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    private int mappedIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        WiggleSort instance = new WiggleSort();
        int[] nums = {5, 5, 5, 1, 1, 1};
        int median = 5;
//        instance.oddEven(nums, median);
//        display(nums);
        instance.oddEvenII(nums, median);
        display(nums);
    }

}
