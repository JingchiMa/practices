package strengthenVI;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    char val;
    ListNode prev;
    ListNode next;
    public ListNode(char val) {
        this.val = val;
    }
}

public class FirstNonRepeating {

    private static final ListNode REMOVED = new ListNode('0');

    private final ListNode dummy;
    private ListNode tail;
    private final Map<Character, ListNode> map;

    public FirstNonRepeating() {
        this.dummy = new ListNode('0');
        tail = dummy;
        this.map = new HashMap<>();
    }

    public Character next(char c) {
        ListNode node = map.get(c);
        if (node == null) {
            node = new ListNode(c);
            map.put(c, node);
            appendToTail(node);
        } else {
            if (node != REMOVED) {
                removeNode(node);
                map.put(c, REMOVED);
            }
        }
        return dummy.next == null ? null : dummy.next.val;
    }

    private void appendToTail(ListNode node) {
        tail.next = node;
        node.prev = tail;
        tail = tail.next;
    }

    private void removeNode(ListNode node) {
        if (node == tail) {
            dummy.next = null;
            node.prev = null;
            tail = dummy;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

