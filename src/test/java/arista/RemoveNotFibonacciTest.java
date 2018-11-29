package arista;

import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.*;

public class RemoveNotFibonacciTest {
    @Test
    public void remove() throws Exception {
        ListNode head = ListNode.getList("10,20,30,40,50,60,70,80");
        RemoveNotFibonacci instance = new RemoveNotFibonacci();
        System.out.println(instance.remove(head));
    }

}