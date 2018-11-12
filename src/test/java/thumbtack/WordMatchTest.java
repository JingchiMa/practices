package thumbtack;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordMatchTest {

    private static final WordMatch instance = new WordMatch();

    @Test
    public void findMatchWordI() throws Exception {
        String[] dict = {"yellow", "white", "bluE"};
        String target = "YellOW";
        assertEquals("yellow", instance.findMatchWordI(dict, target));
    }

    @Test
    public void findMatchWordII() throws Exception {
        String[] dict = {"yellow", "white", "bluE"};
        String target = "yallow";
        assertEquals("yellow", instance.findMatchWordII(dict, target));
    }

    @Test
    public void findMatchWordIII() throws Exception {
        String[] dict = {"yellow", "white", "bluE"};
        String target = "yyyyaAAAalllLLLlllow";
        target = "wwwwhhhhhhhhooooooto";
        assertEquals("white", instance.findMatchWordIII(dict, target));
    }

}