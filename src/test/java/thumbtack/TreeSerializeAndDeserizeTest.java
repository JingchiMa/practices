package thumbtack;

import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.*;

public class TreeSerializeAndDeserizeTest {
    @Test
    public void serialize() throws Exception {

    }

    @Test
    public void deserialize() throws Exception {
        TreeSerializeAndDeserize instance = new TreeSerializeAndDeserize();
        instance.deserialize("1,2,#,#,3");
    }

}