package strengthenII;

import utils.TreeNode;

public class BinarySearchTree {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            prev = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val == val) {
                return root; // the value already exists
            } else {
                cur = cur.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else if (prev.val > val) {
            prev.left = new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertII(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertII(root.right, val);
        } else if (root.val > val) {
            root.left = insertII(root.left, val);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        TreeNode closest = root;
        while (cur != null) {
            if (cur.val == target) {
                return cur;
            }
            if (Math.abs(cur.val - target) < Math.abs(closest.val - target)) {
                closest = cur;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return closest;
    }

    public TreeNode remove(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode parent = new TreeNode(0);
        parent.left = root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == target) {
                TreeNode replacing;
                if (cur.left != null && cur.right != null) {
                    replacing = removeLargest(cur);
                    replacing.right = cur.right;
                    if (cur.left != replacing) {
                        replacing.left = cur.left;
                    }
                } else {
                    replacing = cur.left == null ? cur.right : cur.left;
                }
                if (cur == parent.left) {
                    parent.left = replacing;
                } else {
                    parent.right = replacing;
                }
                break;
            } else if (cur.val < target) {
                parent = cur;
                cur = cur.right;
            } else {
                parent = cur;
                cur = cur.left;
            }
        }
        return root.val == target ? parent.left : root;
    }

    // root is not null and cur.left is not null
    // return the removed node. And the largest node is actually removed from the tree
    private TreeNode removeLargest(TreeNode prev) {
        TreeNode cur = prev.left;
        while (cur.right != null) {
            prev = cur;
            cur = cur.right;
        }
        if (prev.left == cur) {
            prev.left = cur.left;
        } else {
            prev.right = cur.left;
        }
        return cur;
    }


    // return the new root for the tree
    public TreeNode removeII(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            TreeNode replacing;
            if (root.left != null && root.right != null) {
                TreeNode[] rootAndRemoved = removeLargestII(root.left);
                root.left = rootAndRemoved[0];
                replacing = rootAndRemoved[1];
                replacing.left = root.left;
                replacing.right = root.right;
            } else {
                replacing = root.left == null ? root.right : root.left;
            }
            return replacing;
        } else if (root.val < target) {
            root.right = removeII(root.right, target);
        } else {
            root.left = removeII(root.left, target);
        }
        return root;
    }

    private TreeNode[] removeLargestII(TreeNode root) {
        if (root.right == null) {
            return new TreeNode[] {root.left, root};
        }
        TreeNode prev = root;
        TreeNode cur = root.right;
        while (cur.right != null) {
            prev = cur;
            cur = cur.right;
        }
        prev.right = cur.left;
        return new TreeNode[] {root, cur};
    }







}
