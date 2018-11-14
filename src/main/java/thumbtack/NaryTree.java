package thumbtack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    List<TreeNode> children; // no null in children
    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if ( !(another instanceof TreeNode) ) {
            return false;
        }
        TreeNode root = (TreeNode) another;
        return sameTree(this, root);
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val || root1.children.size() != root2.children.size()) {
            return false;
        }
        boolean same = true;
        for (int i = 0; i < root1.children.size(); i++) {
            same = same && sameTree(root1.children.get(i), root2.children.get(i));
        }
        return same;
    }
}
public class NaryTree {

    private static final String SEPARATOR = ",";

    public static String encode(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            sb.append(cur.val).append(SEPARATOR).append(cur.children.size()).append(SEPARATOR);
            for (TreeNode child : cur.children) {
                queue.offer(child);
            }
        }
        return sb.toString();
    }

    public static TreeNode decode(String sequence) {
        if (sequence.isEmpty()) {
            return null;
        }
        String[] values = sequence.split(SEPARATOR);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new ArrayDeque<>(); // queue stores the parent node for previous layer
        Queue<Integer> childNums = new ArrayDeque<>(); // stores the corresponding children number
        queue.offer(root);
        childNums.offer(Integer.parseInt(values[1]));
        int index = 2;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            int childrenNum = childNums.poll();
            for (int i = 0; i < childrenNum; i++) {
                TreeNode child = new TreeNode(Integer.parseInt(values[index]));
                parent.children.add(child);
                queue.offer(child);
                index++;
                childNums.offer(Integer.parseInt(values[index]));
                index++;
            }
        }
        return root;
    }
}
