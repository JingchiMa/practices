package thumbtack;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubstringWithConcatenationWordsTest {
    @Test
    public void findSubstring() throws Exception {
        SubstringWithConcatenationWords instance = new SubstringWithConcatenationWords();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(instance.findSubstring(s, words));
    }

}