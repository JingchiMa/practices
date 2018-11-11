package strengthenVI;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthElementInArrays {

    // Method I: merge
    public static int kthElementI(int[] array1, int[] array2, int k) {
        int i = 0;
        int j = 0;
        Integer num = null;
        while (k > 0) {
            if (i < array1.length && (j >= array2.length || array1[i] <= array2[j])) {
                num = array1[i];
                i++;
            } else { // assume k is always valid
                num = array2[j];
                j++;
            }
            k--;
        }
        return num;
    }

    // Method II: binarySearch

    // k is zero-based
//    public static int findKth(int[] array1, int start1, int[] array2, int start2, int k) {
//        if (k == 0) {
//            if (start1 < array1.length && (start2 >= array2.length || array1[start1] <= array2[start2])) {
//                return array1[start1];
//            } else {
//                return array2[start2];
//            }
//        }
//        // int a = array1[start1 + k / 2];
//        // int b = array2[start2 + k - k/2 - 1];
//        int index1 = start1 + k / 2;
//        int index2 = start2 + k - k/2 - 1;
//        if ( index2 < array2.length &&(index1 >= array1.length || array1[index1] >= array2[index2] ) ) {
//            return findKth(array1, start1, array2, start2 + k - k/2, k / 2);
//        } else {
//            return findKth(array1, start1 + k/2 + 1, array2, start2, k - (k / 2 + 1));
//        }
//    }

    // k >= 1 and k <= a.length + b.length
    // k is 1-based, i.e. offset
    public static int findKth(int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (k == 1) {
            if (aLeft < a.length && (bLeft >= b.length || a[aLeft] <= b[bLeft])) {
                return a[aLeft];
            } else {
                return b[bLeft];
            }
        }
        int indexA = aLeft + k / 2 - 1;
        int indexB = bLeft + k - k / 2 - 1;
        if ( indexA < a.length && (indexB >= b.length || a[indexA] <= b[indexB]) ) {
            return findKth(a, aLeft + k / 2, b, bLeft, k - k/2);
        } else {
            return findKth(a, aLeft, b, bLeft + k - k/2, k / 2);
        }
    }

    public static int[] findFirstK(int[] a, int[] b, int k) {
        return helper(a, 0, b, 0, -1, -1, k);
    }

    // aPrev = the previous index for array a
    // if aPrev == -1, then no elements in a is the first k elements
    private static int[] helper(int[] a, int aLeft, int[] b, int bLeft,
                         int aPrev, int bPrev, int k) {
        if (k == 1) {
            if (aLeft < a.length
                    && (bLeft >= b.length || a[aLeft] <= b[bLeft])) {
                return new int[] {aLeft, bPrev};
            } else {
                return new int[] {aPrev, bLeft};
            }
        }
        int aIndex = aLeft + k / 2 - 1;
        int bIndex = bLeft + (k - k/2) - 1;
        if (aIndex < a.length && (bIndex >= b.length || a[aIndex] <= b[bIndex])) { // move a
            return helper(a, aIndex + 1, b, bLeft, aIndex, bPrev, k - k / 2);
        } else {
            return helper(a, aLeft, b, bIndex + 1, aPrev, bIndex, k / 2);
        }
    }

    // each array in arrays is not null and sorted ascendingly
    // k is always valid
    public int findKthInArrays(int[][] arrays, int k) {
        return findKthInArraysHelper(arrays, new int[arrays.length], k);
    }

    private int findKthInArraysHelper(int[][] arrays, int[] starts, int k) {
        if (k <= arrays.length) { // base case shouldn't be k == 1, instead should be k <= arrays.length
            // find the k-th element in arrays[][0]
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < arrays.length; i++) {
                if (starts[i] >= arrays[i].length ) {
                    continue;
                }
                if (pq.size() < k) {
                    pq.offer(arrays[i][starts[i]]);
                } else {
                    if (pq.peek() > arrays[i][starts[i]]) {
                        pq.poll();
                        pq.offer(arrays[i][starts[i]]);
                    }
                }
            }
            return pq.peek();
        }
        boolean indexNotFound = false;
        int maxArray = 0;
        int maxValue = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            int index = starts[i] + k / arrays.length - 1; // k / arrays.length - 1 can be negative!!
            if (index >= arrays[i].length) {
                indexNotFound = true;
            } else {
                starts[i] += k / arrays.length;
                count++;
                if (maxValue < arrays[i][index]) {
                    maxArray = i;
                    maxValue = arrays[i][index];
                }
            }
        }
        if (!indexNotFound) {
            starts[maxArray] -= k / arrays.length;
            count--;
        }
        return findKthInArraysHelper(arrays, starts, k - count * k / arrays.length);
    }

}
