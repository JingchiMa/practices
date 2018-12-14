package interviews.Houzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupAnagramsTest {
    @Test
    public void groupAnagrams() throws Exception {
        GroupAnagrams instance = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(instance.groupAnagrams(strs));
    }

}