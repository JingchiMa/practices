package strengthenVII;

public class NumberOfElementsWithSmallerValuesAndGreaterIndex {

    public int[] getArray(int[] input) {
        int n = input.length;
        int[] target = new int[n];
        int[] buffer = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        getArray(input, indices, 0, n-1, buffer, target);
        return target;
    }

    // both inclusive
    // this function will sort ascending the indices based on their corresponding values in input, and will
    // update the correct number in target. target[i] = the number of numbers whose values are smaller than input[i],
    // and has greater index than i.
    private void getArray(int[] input, int[] indices, int start, int end, int[] buffer, int[] target) {
        if (start >= end) {
            return;
        }
        int mid = ( start + end ) / 2;
        getArray(input, indices, start, mid, buffer, target);
        getArray(input, indices, mid + 1, end, buffer, target);

        int i = start; // the index for left part for indices array
        int j = mid + 1; // the index for right part for indices array
        int k = start; // index for buffer
        while (i <= mid && j <= end) {
            int first = indices[i]; // original index for input array
            int second = indices[j]; // original index for input array
            if (input[first] <= input[second]) {
                buffer[k] = first;
                target[first] += (j - (mid + 1));
                i++;
            } else {
                buffer[k] = second;
                j++;
            }
            k++;
        }
        while (i <= mid) {
            int first = indices[i];
            buffer[k] = first;
            target[first] += (j - (mid + 1)); // the movement for j index
            i++;
            k++;
        }
        while (j <= end) {
            int second = indices[j];
            buffer[k] = second;
            j++;
            k++;
        }
        System.arraycopy(buffer, start, indices, start, end - start + 1);
    }
}
