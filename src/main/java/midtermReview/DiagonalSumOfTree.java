package midtermReview;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DiagonalSumOfTree {

    public List<Integer> diagonalSums(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> sums = new ArrayList<>();
        dfs(root, 0, sums);
        return sums;
    }

    // each time we goes to level child, add level by 1
    private void dfs(TreeNode root, int level, List<Integer> sums) {
        if (root == null) {
            return;
        }
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
        } else {
            sums.add(root.val); // size + 1 < level?
        }
        dfs(root.right, level, sums);
        dfs(root.left, level + 1, sums);
    }

}
