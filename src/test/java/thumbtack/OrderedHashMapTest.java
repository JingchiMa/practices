package thumbtack;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderedHashMapTest {

    @Test
    public void putTest() throws Exception {
        OrderedHashMap<String, Integer> instance = new OrderedHashMap<>();
        instance.put("good", 1);
        instance.put("better", 2);
        instance.put("best", 3);
        System.out.println(instance);
    }

    @Test
    public void toStringTest() throws Exception {

    }

}