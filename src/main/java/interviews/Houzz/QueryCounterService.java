package interviews.Houzz;

import java.util.*;

public class QueryCounterService {

    // doubly-linked list, value is the count for the corresponding query
    private static class ListNode {
        private String key;
        private int val;
        ListNode prev;
        ListNode next;
        ListNode(String key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + key + "," + val + "]";
        }
    }
    private Map<String, ListNode> map = new HashMap<>();
    private ListNode dummy = new ListNode("", 0);
    private ListNode tail = dummy;

    void addCount(String query) {
        // add query count + 1
        ListNode cur = map.get(query);
        if (cur == null) {
            cur = new ListNode(query, 0);
            tail.next = cur;
            cur.prev = tail;
            tail = tail.next;
            map.put(query, cur);
        }
        cur.val++;
        if (cur.prev != dummy && cur.val > cur.prev.val) {
            swapWithPrev(cur);
        }
    }

    // if no such query, return 0
    int getCount(String query) {
        // return current query count
        ListNode node = map.get(query);
        return node == null ? 0 : node.val;
    }

    List<String> getTopKFrequentQueries(int k) {
        // get current top most frequent k queries sorted by the counter
        List<String> results = new ArrayList<>();
        ListNode cur = dummy.next;
        for (int i = 0; i < k && cur != null; i++) {
            results.add(cur.key);
            cur = cur.next;
        }
        return results;
    }

    // assumption: cur.prev is not dummy
    private void swapWithPrev(ListNode cur) {
        ListNode prevPrev = cur.prev.prev;
        ListNode prev = cur.prev;
        ListNode next = cur.next;
        prevPrev.next = cur;
        cur.prev = prevPrev;
        cur.next = prev;
        prev.prev = cur;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
    }
}

