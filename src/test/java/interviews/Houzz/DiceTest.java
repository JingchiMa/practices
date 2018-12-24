package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    @Test
    public void dfs() throws Exception {
        Dice instance = new Dice();
        System.out.println(instance.dfs(2, 2));
    }

}