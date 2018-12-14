package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class LCATest {
    @Test
    public void getLCAofDeepestNodes() throws Exception {
        LCA instance = new LCA();
        TreeNode root = new TreeNode(0);
        TreeNode child1 = new TreeNode(2);
        child1.children.add(new TreeNode(5));
        TreeNode child2 = new TreeNode(3);
        child2.children.add(new TreeNode(6));
        TreeNode child3 = new TreeNode(4);
        child3.children.add(new TreeNode(7));
        child3.children.add(new TreeNode(8));
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        assertEquals(root, instance.getLCAofDeepestNodes(root));
    }

    @Test
    public void getLCAofDeepestNodesTest2() throws Exception {
        LCA instance = new LCA();
        TreeNode root = new TreeNode(0);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        child3.children.add(new TreeNode(7));
        child3.children.add(new TreeNode(8));
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        assertEquals(child3, instance.getLCAofDeepestNodes(root));
    }

}