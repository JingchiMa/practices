package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calculate() throws Exception {
        Calculator instance = new Calculator();
        System.out.println(instance.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    @Test
    public void calculateII() throws Exception {
        Calculator instance = new Calculator();
        System.out.println(instance.calculateII("(1+1)"));
    }


}