package midtermReview;

import org.junit.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.Assert.*;

public class NodesWithShortedPathsTest {
    @Test
    public void findNodes() throws Exception {
        NodesWithShortedPaths instance = new NodesWithShortedPaths();
        thumbtack.TreeSerializeAndDeserize treeConstructor = new thumbtack.TreeSerializeAndDeserize();
        TreeNode root = treeConstructor.deserialize("1,2,4,7,#,#,8,#,#,5,#,#,3,#,6,9,#,#,#");
        System.out.println(root);
        List<TreeNode> nodes = instance.findNodes(root, 4);
        for (TreeNode node: nodes) {
            System.out.println(node.val);
        }
    }

}