package review;

import utils.Point;

import java.util.Arrays;
import java.util.Comparator;

public class PointsWithPositiveSlope {
    public int largest(Point[] points) {
        // step 1: sort the input points based on x coordinate in ascending order
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.x - p2.x;
            }
        });

        // step 2: find the longest increasing subsequence based on y from the sorted points
        int[] tails = new int[points.length + 1]; // tails[i] = the min tail element for the subsequence whose length is i
        int size = 0; // the max lengths in the subsequence that I've seen

        for (Point p : points) {
            if (size == 0 || p.y > tails[size]) {
                tails[size + 1] = p.y;
                size++;
            } else {
                int index = binarySearch(tails, size, p.y);
                tails[index] = p.y;
            }
        }
        if (size == 1) {
            return 0;
        }
        return size;
    }
    // find the index of the smallest element which is greater than or equal to the target
    // end is inclusive
    private int binarySearch(int[] array, int end, int target) {
        int left = 0;
        int right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (array[left] >= target) {
            return left;
        }
        return -1; // not found, every element in the array is strictly smaller than target
    }

}
