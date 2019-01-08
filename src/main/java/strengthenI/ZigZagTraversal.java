package strengthenI;

import utils.TreeNode;
import java.util.*;

public class ZigZagTraversal {
    List<List<Integer>> zigZagPrint(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        List<List<Integer>> results = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                if (level % 2 == 0) {
                    cur = deque.pollFirst();
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    cur = deque.pollLast();
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
                nodes.add(cur.val);
            }
            level++;
            results.add(nodes);
        }
        return results;
    }

}
