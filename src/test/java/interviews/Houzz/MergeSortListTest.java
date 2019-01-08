package interviews.Houzz;

import org.junit.Test;
import utils.ListNode;

import static org.junit.Assert.*;

public class MergeSortListTest {
    @Test
    public void sortList() throws Exception {
        MergeSortList instance = new MergeSortList();
        ListNode head = ListNode.getList("4,2,1,3");
        System.out.println(instance.sortList(head));
    }

}