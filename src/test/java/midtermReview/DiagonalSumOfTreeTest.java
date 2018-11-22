package midtermReview;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DiagonalSumOfTreeTest {
    @Test
    public void diagonalSums() throws Exception {
        DiagonalSumOfTree instance = new DiagonalSumOfTree();
        List<Integer> expected = new ArrayList<>(Arrays.asList(11, 14, 5));
        thumbtack.TreeSerializeAndDeserize treeConstructor = new thumbtack.TreeSerializeAndDeserize();
        TreeNode root = treeConstructor.deserialize("1,2,4,#,#,5,1,#,#,#,3,6,#,1,#,#,7,#,#");
        assertEquals(expected, instance.diagonalSums(root));
    }

}