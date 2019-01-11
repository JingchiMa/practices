package interviews.Houzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NestedIteratorTest {

    @Test
    public void test() {
        String s = "[1,2,[1,3],[2,5,[7,8]]]";
        List<NestedInteger> input = NestedInteger.nestedIntegers(s);
        NestedIterator iterator = new NestedIterator(input);
        List<Integer> results = new ArrayList<>();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }
        System.out.println(results);
    }

    @Test
    public void testMultipleHasNext() {
        String s = "[1,2,[1,3],[2,5,[7,8]]]";
        List<NestedInteger> input = NestedInteger.nestedIntegers(s);
        NestedIterator iterator = new NestedIterator(input);
        List<Integer> results = new ArrayList<>();
        while (iterator.hasNext()) {
            iterator.hasNext();
            results.add(iterator.next());
        }
        System.out.println(results);
    }

    @Test
    public void testWithoutHasNext() {
        String s = "[1,2,[1,3],[2,5,[7,8]]]";
        List<NestedInteger> input = NestedInteger.nestedIntegers(s);
        NestedIterator iterator = new NestedIterator(input);
        List<Integer> results = new ArrayList<>();
        Integer cur = iterator.next();
        while (cur != null) {
            results.add(cur);
            cur = iterator.next();
        }
        System.out.println(results);
    }

}