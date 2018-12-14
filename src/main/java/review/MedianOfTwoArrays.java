package review;

import java.util.Arrays;

public class MedianOfTwoArrays {

    public double medianUnsorted(int[] a, int[] b) {
        // I forgot that The two given array are not guaranteed to be sorted!!!!!!

        /*
        k-th element in the array
        [a][b]
        left = 0
        right = a.length + b.length
        while left <= right
          choose a pivot
          while [left] <= pivot
            left++
          while [right] > pivot
            right--
          if left < right, then
            swap(a, b, left, right)
            left++
            right--
        # right, left
        if right - 0 + 1 >= k, then recursively call on [a][b] [0: right]
        else recursively call on [a][b] [left, end]

        func getValue(int[] a, int[] b, int index):
          if index < a.length
            return a[index]
          else
            return b[index - a.length]

        func swap(int[] a, int[] b, int left, int right):
          if right < a.length, then
            swap(a, left, right)
          else if left >= a.length
            swap(b, left - a.length, right - a.length)
          else
            int tmp = a[left]
            a[left] = b[right]
            b[right] = tmp
        */
        int len = a.length + b.length;
        if (len % 2 == 0) {
            return (getKth(a, b, 0, len-1, len/2) + getKth(a, b, 0, len-1, len/2 + 1)) / 2.0;
        } else {
            return getKth(a, b, 0, len-1, (len/2));
        }
    }

    private int getKth(int[] a, int[] b, int start, int end, int k) {
        if (k == 1) {
            return getValue(a, b, start);
        }
        int left = start;
        int right = end;
        int pivot = getValue(a, b, (start + end) / 2);
        while (left <= right) {
            while (left <= right && getValue(a, b, left) < pivot) {
                left++;
            }
            while (left <= right && getValue(a, b, right) > pivot) {
                right--;
            }
            if (left <= right) {
                swap(a, b, left, right);
                left++;
                right--;
            }
        }
        // right, left
        if (right - start + 1 >= k) {
            return getKth(a, b, start, right, k);
        } else if (left - start < k) {
            return getKth(a, b, left, end, k - (left - start));
        } else {
            return getValue(a, b, right + 1);
        }
    }

    // 0 <= index < a.length + b.length
    private int getValue(int[] a, int[] b, int index) {
        if (index < a.length) {
            return a[index];
        } else {
            return b[index - a.length];
        }
    }

    // 0 <= left <= right < a.length + b.length
    private void swap(int[] a, int[] b, int left, int right) {
        if (right < a.length) {
            swap(a, left, right);
        } else if (left >= a.length) {
            swap(b, left - a.length, right - a.length);
        } else {
            int tmp = a[left];
            a[left] = b[right - a.length];
            b[right - a.length] = tmp;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
