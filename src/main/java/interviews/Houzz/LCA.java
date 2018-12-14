package interviews.Houzz;

import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> children = new ArrayList<>();

    TreeNode(int val) {
        this.val = val;
    }
}

public class LCA {

    static class ResultType {
        TreeNode node;
        int height;
        ResultType(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    TreeNode getLCAofDeepestNodes(TreeNode root) {
        return helper(root, 0).node;
    }

    private ResultType helper(TreeNode root, int height) {
        if (root == null) {
            return new ResultType(null, 0);
        }
        if (root.children.isEmpty()) {
            return new ResultType(root, height);
        }
        ResultType max = null;
        int count = 0;
        for (TreeNode child : root.children) {
            ResultType subResult = helper(child, height + 1);
            if (max == null || max.height < subResult.height) {
                max = subResult;
                count = 1;
            } else if (max.height == subResult.height) {
                count++;
            }
        }
        if (count > 1) {
            return new ResultType(root, max.height);
        } else {
            return max;
        }
    }

}
