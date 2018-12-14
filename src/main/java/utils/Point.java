package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point another = (Point) o;
        return this.x == another.x && this.y == another.y;
    }

    @Override
    public int hashCode() {
        return new ArrayList<>(Arrays.asList(x, y)).hashCode();
    }
}
