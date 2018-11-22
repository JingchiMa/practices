package strengthenV;

import java.util.ArrayList;
import java.util.List;

public class CommonElements {

    // end1 and end2 exclusive
    public int commonElementsInTwoSortedArrays(int[] array1, int end1, int[] array2, int end2, int[] results) {
        int size = 0;
        int i = 0; // for array1
        int j = 0; // for array2
        /*
        if array1[i] < array2[j], then no match for array1[i], i++
        else if array[i] == array2[j], match, add to results[size], size++. skip the same numbers
        else array1[i] > array2[j], then no match for array2[j], j++
         */
        while (i < end1 && j < end2) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array1[i] == array2[j]) {
                results[size] = array1[i];
                size++;
                i++;
                j++;
                while (i < end1 && array1[i] == array1[i-1]) {
                    i++;
                }
                while (j < end2 && array2[j] == array2[j-1]) {
                    j++;
                }
            } else {
                j++;
            }
        }
        return size;
    }

    // assumptions: arrays is not null or empty, and arrays[i] is not null or empty
    public List<Integer> commonElementsInKSortedArrays(int[][] arrays) {
        int maxLen = getMaxLength(arrays);
        int[] input = new int[maxLen];
        System.arraycopy(arrays[0], 0, input, 0, arrays[0].length);
        int size = arrays[0].length; // real length for input array
        int[] output = new int[maxLen]; // output
        // input + array[i] -> output
        for (int i = 1; i < arrays.length; i++) {
            size = commonElementsInTwoSortedArrays(input, size, arrays[i], arrays[i].length, output);
            int[] tmp = input;
            input = output;
            output = tmp;
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            results.add(input[i]);
        }
        return results;
    }

    private int getMaxLength(int[][] arrays) {
        int max = 0;
        for (int[] array : arrays) {
            max = Math.max(max, array.length);
        }
        return max;
    }
}
