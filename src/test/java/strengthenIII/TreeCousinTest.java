package strengthenIII;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class TreeCousinTest {
    @Test
    public void isCounsin() throws Exception {
        TreeCousin instance = new TreeCousin();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        root.left.left = a;
        root.right = new TreeNode(2);
        TreeNode b = new TreeNode(4);
        root.right.right = b;
        assertEquals(true, instance.isCousin(root, a, b));
    }

    @Test
    public void isCousinDFSTest1() throws Exception {
        TreeCousin instance = new TreeCousin();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        root.left.left = a;
        root.right = new TreeNode(2);
        TreeNode b = new TreeNode(4);
        root.right.right = b;
        assertEquals(true, instance.isCousinDFS(root, a, b));
    }

    @Test
    public void isCousinDFSTest2() throws Exception {
        TreeCousin instance = new TreeCousin();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        TreeNode a = new TreeNode(4);
        root.left.left = a;
        TreeNode b = new TreeNode(5);
        root.left.right = b;
        root.right = new TreeNode(3);
        assertEquals(false, instance.isCousinDFS(root, a, b));
    }

    @Test
    public void isCousinDFSTest3() throws Exception {
        TreeCousin instance = new TreeCousin();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        TreeNode a = new TreeNode(4);
        root.left.left = a;
        TreeNode b = new TreeNode(7);
        a.left = b;
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        assertEquals(false, instance.isCousinDFS(root, a, b));
    }

}