package strengthenIV;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class ReverseBinaryTreeTest {
    @Test
    public void reverseBT() throws Exception {
        ReverseBinaryTree instance = new ReverseBinaryTree();
        thumbtack.TreeSerializeAndDeserize serializer = new thumbtack.TreeSerializeAndDeserize();
        TreeNode root = serializer.deserialize("1,2,4,#,#,5,#,#,3,#,#");
        System.out.println(root);
        System.out.println(instance.reverseBT(root));
    }

    @Test
    public void reverseBTII() throws Exception {
        ReverseBinaryTree instance = new ReverseBinaryTree();
        thumbtack.TreeSerializeAndDeserize serializer = new thumbtack.TreeSerializeAndDeserize();
        TreeNode root = serializer.deserialize("1,2,4,#,#,5,#,#,3,#,#");
        System.out.println(root);
        System.out.println(instance.reverseBTII(root));
    }
}