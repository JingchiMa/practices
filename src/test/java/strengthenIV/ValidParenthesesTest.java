package strengthenIV;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {
    @Test
    public void validParentheses() throws Exception {
        ValidParentheses instance = new ValidParentheses();
        System.out.println(instance.validParentheses(new int[] {1, 1, 1}));
    }

}