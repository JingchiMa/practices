package thumbtack;

import utils.TreeNode;

public class TreeSerializeAndDeserize {

    private static final String SEPARATOR = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEPARATOR);
            return;
        }
        sb.append(root.val).append(SEPARATOR);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(SEPARATOR);
        int[] index = new int[1];
        TreeNode root = construct(values, index);
        System.out.println(values.length);
        System.out.println(index[0]);
        return root;
    }

    private TreeNode construct(String[] values, int[] index) {
        if (index[0] >= values.length || values[index[0]].equals(NULL)) {
            index[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        cur.left = construct(values, index);
        cur.right = construct(values, index);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));