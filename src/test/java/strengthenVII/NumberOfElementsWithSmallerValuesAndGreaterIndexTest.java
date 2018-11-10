package strengthenVII;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class NumberOfElementsWithSmallerValuesAndGreaterIndexTest {
    @Test
    public void getArrayTest1() throws Exception {
        NumberOfElementsWithSmallerValuesAndGreaterIndex instance = new NumberOfElementsWithSmallerValuesAndGreaterIndex();
        int[] input = {4, 3, 5, 1};
        int[] res = instance.getArray(input);
        int[] expected = {2, 1, 1, 0};
        assertArrayEquals(expected, res);
    }

    @Test
    public void getArrayTest2() throws Exception {
        NumberOfElementsWithSmallerValuesAndGreaterIndex instance = new NumberOfElementsWithSmallerValuesAndGreaterIndex();
        int[] input = {4, 10, 7, 8, 3, 5, 1};
        int[] res = instance.getArray(input);
        int[] expected = {2, 5, 3, 3, 1, 1, 0};
        assertArrayEquals(expected, res);
    }

}