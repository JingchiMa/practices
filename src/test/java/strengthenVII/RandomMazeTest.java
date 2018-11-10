package strengthenVII;

import org.junit.Test;

import javax.management.relation.RelationNotFoundException;

import static org.junit.Assert.*;
import static utils.Display.display;

public class RandomMazeTest {
    @Test
    public void generateRandomMaze() throws Exception {
        RandomMaze instance = new RandomMaze();
        int[][] maze = instance.generateRandomMaze(5);
        display(maze);
    }

}