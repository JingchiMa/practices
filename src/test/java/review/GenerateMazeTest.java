package review;

import org.junit.Test;

import static org.junit.Assert.*;
import static utils.Display.display;

public class GenerateMazeTest {
    @Test
    public void maze() throws Exception {
        GenerateMaze instance = new GenerateMaze();
        int[][] matrix = instance.maze(5);
        display(matrix);
    }

}