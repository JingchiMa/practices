package interviews.Houzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TripArrangementTest {
    @Test
    public void findPath() throws Exception {
        TripArrangement instance = new TripArrangement();
        List<String> table = new ArrayList<>(Arrays.asList("A B 1000 1130", "B C 1200 1230", "A C 1100 1250"));
        String src = "A";
        String dst = "C";
        System.out.println(instance.findPath(table, src, dst));
    }

}