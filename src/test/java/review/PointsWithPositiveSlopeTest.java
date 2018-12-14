package review;

import org.junit.Test;
import utils.Point;

import static org.junit.Assert.*;

public class PointsWithPositiveSlopeTest {
    @Test
    public void largest() throws Exception {
        PointsWithPositiveSlope instance = new PointsWithPositiveSlope();
        Point[] input = {new Point(1,2), new Point(1,3)};
        assertEquals(0, instance.largest(input));
    }

}