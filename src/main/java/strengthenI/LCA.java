package strengthenI;

import utils.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCA {
    TreeNode getLCA(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>();
        set.addAll(nodes);
        TreeNode LCA = helper(root, set);
        return set.isEmpty() ? LCA : null;
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> nodes) {
        if (root == null) {
            return null;
        }
        boolean found = nodes.remove(root);
        TreeNode left = helper(root.left, nodes);
        TreeNode right = helper(root.right, nodes);
        if (found || left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
