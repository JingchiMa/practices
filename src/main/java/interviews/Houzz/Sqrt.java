package interviews.Houzz;

public class Sqrt {
    public static double sqrt(double num, double delta) {
        if (num == 0 || num == 1) {
            return num;
        }
        // delta > 0, num >= 0
        double left = 0; // (left, right)
        double right = Math.max(num, 1);
        while (left < right) {
            double mid = (right - left) / 2 + left;
            if (Math.pow(mid + delta, 2) < num) {
                left = mid;
            } else if (mid >= delta && Math.pow(mid - delta, 2) > num) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1; // shouldn't be reachable
    }
}
