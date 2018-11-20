package ood.NavalWarfares;

public class Point {

    private static final int RANGE = 5;

    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point random() {
        int x = (int) (Math.random() * RANGE);
        int y = (int) (Math.random() * RANGE);
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
