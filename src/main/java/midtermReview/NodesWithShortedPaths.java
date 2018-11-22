package midtermReview;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodesWithShortedPaths {

    public List<TreeNode> findNodes(TreeNode root, int k) {
        List<TreeNode> results = new ArrayList<>();
        helper(root, 0, results, k);
        return results;
    }

    // return value is the max length among all paths which go through the current root node
    private int helper(TreeNode root, int prev, List<TreeNode> results, int k) {
        if (root == null) {
            return prev;
        }
        int left = helper(root.left, prev + 1, results, k);
        int right = helper(root.right, prev + 1, results, k);
        if (left < k && right < k) {
            results.add(root);
        }
        return Math.max(left, right);
    }

}
