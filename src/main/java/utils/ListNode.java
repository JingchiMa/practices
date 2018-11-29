package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode getList(String nodes) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for (String node : nodes.split(",")) {
            prev.next = new ListNode(Integer.parseInt(node));
            prev = prev.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
