package interviews.Houzz;

import arista.RemoveNotFibonacci;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveFactoriesTest {
    @Test
    public void removeFactories() throws Exception {
        RemoveFactories instance = new RemoveFactories();
        int[] array = {0, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(instance.removeFactories(array, 2));
    }

    @Test
    public void removeFactoriesTest2() throws Exception {
        RemoveFactories instance = new RemoveFactories();
        int[] array = {0, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(instance.removeFactories(array, 1));
    }

    @Test
    public void removeFactoriesTest3() throws Exception {
        RemoveFactories instance = new RemoveFactories();
        int[] array = {0, 0, 1, 1, 0, 0, 0, 1, 0, 1};
        System.out.println(instance.removeFactories(array, 2));
    }

    @Test
    public void removeFactoriesTest4() throws Exception {
        RemoveFactories instance = new RemoveFactories();
        int[] array = {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1};
        System.out.println(instance.removeFactories(array, 2));
    }

}