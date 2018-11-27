package strengthenIII;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class PathSumInTreeTest {
    @Test
    public void pathSumEqualsTarget() throws Exception {
        PathSumInTree instance = new PathSumInTree();
        TreeNode root = new thumbtack.TreeSerializeAndDeserize().deserialize("1,2,4,#,#,5,#,6,#,#,3,#,#");
        assertEquals(true, instance.pathSumEqualsTarget(root, 13));
    }

}