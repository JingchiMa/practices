package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParseDoubleTest {
    private ParseDouble instance = new ParseDouble();

    @Test
    public void parse() throws Exception {
        System.out.println(instance.parse(".34"));
        System.out.println(instance.parse("0.34"));
        System.out.println(instance.parse("1.34"));
        System.out.println(instance.parse("1."));
        System.out.println(instance.parse("-0.2"));
        System.out.println(instance.parse("20.34"));
        System.out.println(instance.parse("-.34"));
        System.out.println(instance.parse("-1."));

    }

    @Test(expected = ParseDouble.IllegalDoubleFormatException.class)
    public void testWrongFormatI() throws ParseDouble.IllegalDoubleFormatException{
        System.out.println(instance.parse("-+1."));
    }

    @Test(expected = ParseDouble.IllegalDoubleFormatException.class)
    public void testWrongFormatII() throws ParseDouble.IllegalDoubleFormatException{
        System.out.println(instance.parse("-.1."));
    }

}