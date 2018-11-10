package strengthenVII;

public class NumberOfElementsWithSmallerValuesAndGreaterIndex {

    public int[] getArray(int[] input) {
        int n = input.length;
        int[] target = new int[n];
        int[] buffer = new int[n];
        int[] targetBuffer = new int[n];
        getArray(input, 0, n-1, buffer, target, targetBuffer);
        return target;
    }

    // both inclusive
    private void getArray(int[] input, int start, int end, int[] buffer, int[] target, int[] targetBuffer){

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        getArray(input, start, mid, buffer, target, targetBuffer);
        getArray(input, mid + 1, end, buffer, target, targetBuffer);
        // input[start, mid]: sorted ascendingly
        // input[mid+1, end]: sorted ascendingly
        // target[start, mid]: target[i] stores the num for input[i]
        // target[mid, end]: target[i] stores the num for input[i]

        int i = 0; //
        int j = mid + 1; // with offset = mid + 1
        while (i <= mid && j <= end) {
            if (input[i] <= input[j]) {
                buffer[i + j - (mid + 1)] = input[i];
                targetBuffer[i + j - (mid + 1)] = target[i] + j - (mid + 1);
                i++;
            } else {
                buffer[i + j - (mid + 1)] = input[j];
                targetBuffer[i + j - (mid + 1)] = target[j];
                j++;
            }
        }
        while (i <= mid) {
            buffer[i + j - (mid + 1)] = input[i];
            targetBuffer[i + j - (mid + 1)] = target[i] + j - (mid + 1);
            i++;
        }
        while (j <= end) {
            buffer[i + j - (mid + 1)] = input[j];
            targetBuffer[i + j - (mid + 1)] = target[j];
            j++;
        }

        System.arraycopy(buffer, start, input, start, end - start + 1);
        System.arraycopy(targetBuffer, start, target, start, end - start + 1);
    }

}
