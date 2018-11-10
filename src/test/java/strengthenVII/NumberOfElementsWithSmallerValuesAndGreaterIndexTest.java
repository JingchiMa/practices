package strengthenVII;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class NumberOfElementsWithSmallerValuesAndGreaterIndexTest {
    @Test
    public void getArray() throws Exception {
        NumberOfElementsWithSmallerValuesAndGreaterIndex instance = new NumberOfElementsWithSmallerValuesAndGreaterIndex();
        int[] input = {4, 3, 5, 1};
        int[] res = instance.getArray(input);
        display(res);
        display(input);
    }

}