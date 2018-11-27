package strengthenIII;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeCousin {

    public boolean isCousin(TreeNode root, TreeNode a, TreeNode b) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean seenA = false;
            boolean seenB = false;
            for (int i = 0; i < size; i++) {
                TreeNode parent = queue.poll();
                if (parent.left == a && parent.right == b
                        || parent.right == a && parent.left == b) {
                    return false;
                }
                if (parent.left == a || parent.right == a) {
                    seenA = true;
                }
                if (parent.left == b || parent.right == b) {
                    seenB = true;
                }
                if (parent.left != null) {
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                }
            }
            if (seenA && seenB) {
                return true;
            } else if (seenA || seenB) {
                return false;
            }
        }
        return false;
    }

    static class NodeAndHeight {
        TreeNode node;
        int height;
        NodeAndHeight(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public boolean isCousinDFS(TreeNode root, TreeNode a, TreeNode b) {
        NodeAndHeight result = helper(root, 0, a, b);
        if (result == null || result.node == a || result.node == b) {
            return false;
        }
        return true;
    }

    private NodeAndHeight helper(TreeNode root, int height, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return new NodeAndHeight(root, height);
        }
        NodeAndHeight left = helper(root.left, height + 1, a, b);
        NodeAndHeight right = helper(root.right, height + 1, a, b);
        if (left != null && right != null) {
            if (root.left == a && root.right == b
                    || root.left == b && root.right == a) {
                return null;
            } else if (left.height != right.height){
                return null;
            } else {
                return new NodeAndHeight(root, 0);
            }
        }
        return left != null ? left : right; // 要保证返回值能够传回去
    }


}
