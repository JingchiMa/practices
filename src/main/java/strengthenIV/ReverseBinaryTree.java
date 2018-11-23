package strengthenIV;

import utils.TreeNode;

public class ReverseBinaryTree {

    public TreeNode reverseBT(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        return reverseBTHelper(root, left, right);
    }

    private TreeNode reverseBTHelper(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) { // edge case
            return null;
        }
        if (left == null) { // implies right == null
            return root;
        }
        TreeNode nextLeft = left.left;
        TreeNode nextRight = left.right;
        left.right = root;
        left.left = right;
        return reverseBTHelper(left, nextLeft, nextRight);
    }

    public TreeNode reverseBTII(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) { // edge case
            return null;
        }
        if (root.left == null) { // forgot base case
            return root;
        }
        TreeNode newRoot = helper(root.left);
        // root.left.left = null and root.left.right = null now
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }


}
