package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorsTest {
    @Test
    public void generatePrimeFactors() throws Exception {
        PrimeFactors instance = new PrimeFactors();
        System.out.println(instance.generatePrimeFactors(100));
    }

    @Test
    public void generatePrimeFactorsInPower() throws Exception {
        PrimeFactors instance = new PrimeFactors();
        System.out.println(instance.generatePrimeFactorsInPower(400));
    }

    @Test
    public void generatePrimeFactorsInReverseOrder() throws Exception {
        PrimeFactors instance = new PrimeFactors();
        System.out.println(instance.generatePrimeFactorsInReverseOrder(20));
    }

}