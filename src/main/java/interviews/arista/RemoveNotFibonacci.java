package interviews.arista;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveNotFibonacci {
    public ListNode remove(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        Set<Integer> set = new HashSet<>(); // stores the fab numbers
        set.add(1);
        int[] largestFibs = {1, 1};
        while (head != null) {
            if (!inFabonacci(head.val, set, largestFibs)) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    //
    private boolean inFabonacci(int num, Set<Integer> set, int[] largestFibs) {
        if (num <= 0) {
            return false;
        }
        if (set.contains(num)) {
            return true;
        }
        // num >= 2
        while (largestFibs[1] <= num) {
            if (largestFibs[1] == num) {
                return true;
            }
            int tmp = largestFibs[1];
            largestFibs[1] += largestFibs[0];
            largestFibs[0] = tmp;
        }
        return false;
    }

}
