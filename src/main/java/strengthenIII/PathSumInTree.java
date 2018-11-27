package strengthenIII;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class PathSumInTree {

    public boolean pathSumEqualsTarget(TreeNode root, int target) {
        Set<Integer> prefixSum = new HashSet<>();
        boolean res = helper(root, 0, prefixSum, target);
        System.out.println(prefixSum);
        return res;
    }

    private boolean helper(TreeNode root, int prev, Set<Integer> prefixSum, int target) {
        if (root == null) {
            return false;
        }
        if (prefixSum.contains(prev + root.val - target)) {
            return true;
        }
        prefixSum.add(prev + root.val);// 还需要remove！！这个prefixSum不是一个global的，而是path-specific，所以必须吃了吐这样
        if (helper(root.left, prev + root.val, prefixSum, target)) {
            return true;
        }
        if (helper(root.right, prev + root.val, prefixSum, target)) {
            return true;
        }
        prefixSum.remove(prev + root.val);
        return false;
    }

}
