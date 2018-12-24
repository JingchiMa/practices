package interviews.Houzz;

public class CircleInGrid {

    int squareNums(int n, double cx, double cy, double r) {

        int lo = (int) Math.max( Math.ceil(cy - r), 0 );
        int hi = (int) Math.min( Math.floor(cy + r), n );
        int count = 0;
        for (int lowLine = lo; lowLine < hi; lowLine++) {
            int highLine = lowLine + 1;
            double[] lows = getIntersection(cx, cy, r, lowLine);
            double[] highs = getIntersection(cx, cy, r, highLine);
            double left = Math.max ( Math.max(lows[0], highs[0]), 0 );
            double right = Math.min ( Math.min(lows[1], highs[1]), n );
            count += (Math.floor(right) - Math.ceil(left));
        }
        return count;
    }

    private double[] getIntersection(double cx, double cy, double r, int line) {
        double tmp = Math.sqrt(r * r - (line - cy) * (line - cy));
        return new double[] {cx - tmp, cx + tmp};
    }

}
