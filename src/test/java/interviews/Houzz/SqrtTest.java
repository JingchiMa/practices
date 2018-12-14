package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {
    @Test
    public void sqrtTest1() throws Exception {
        double num = 25.1;
        double delta = 0.01;
        double res = Sqrt.sqrt(num, delta);
        System.out.println(res);
        assertEquals(res, Math.sqrt(num), delta);
    }

    @Test
    public void sqrtTest2() throws Exception {
        double num = 0.01; // 0.1
        double delta = 0.1;
        double res = Sqrt.sqrt(num, delta);
        System.out.println(res);
        assertEquals(res, Math.sqrt(num), delta);
    }

    @Test
    public void sqrtTest3() throws Exception {
        double num = 0.01; // 0.1
        double delta = 0.001;
        double res = Sqrt.sqrt(num, delta);
        System.out.println(res);
        assertEquals(res, Math.sqrt(num), delta);
    }

}