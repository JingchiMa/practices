package interviews.Houzz;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NestedIntegerTest {
    @Test
    public void nestedIntegers() throws Exception {
        String input = "[1, 2, [3, 4], [5, 6, [7, 8]]]";
        List<NestedInteger> list = NestedInteger.nestedIntegers(input);
        System.out.println(list);
    }

    @Test
    public void testBuild() throws Exception {
        String input = "[1, 2, [3, 4], [5, 6, [7, 8]]]";
        List<NestedInteger> list = NestedInteger.build(input);
        System.out.println(list);
    }

    @Test
    public void testBuildWithNegativeNumbers() throws Exception {
        String input = "[-1, 2, [-3, 4], [5, 6, [-7, 8]]]";
        List<NestedInteger> list = NestedInteger.build(input);
        System.out.println(list);
    }

    @Test
    public void testBuildWithMoreDigits() throws Exception {
        String input = "[-1, 2, [-30, 4], [500, 6, [-70, 8]]]";
        List<NestedInteger> list = NestedInteger.build(input);
        System.out.println(list);
    }

}