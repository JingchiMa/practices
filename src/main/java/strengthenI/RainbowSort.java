package strengthenI;

public class RainbowSort {
    public void sortColors2(int[] colors, int k) {
        // solution II: recursive
        // left : [1, k/2] startColor, endColor, start, end
        // right: [k/2, k]
        // base case: start >= end or startColor >= endColor
        helper(colors, 0, colors.length - 1, 1, k);
    }

    private void helper(int[] colors, int start, int end, int startColor, int endColor) {
        if (start >= end || startColor >= endColor) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = (startColor + endColor) / 2;
        while (left <= right) {
            while (left <= right && colors[left] <= pivot) {
                left++;
            }
            while (left <= right && colors[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(colors, left, right);
                left++;
                right--;
            }
        }
        helper(colors, start, right, startColor, pivot);
        helper(colors, left, end, pivot + 1, endColor);
    }

    private void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}
