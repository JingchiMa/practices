package quora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutputStrings {
    public void printString(List<String> input, List<Integer> nums) {
        int outOfBound = 0;
        int[] indices = new int[input.size()];
        while (outOfBound < input.size()) {
            for (int i = 0; i < input.size() && outOfBound < input.size(); i++) {
                if (i != 0) {
                    System.out.print("|");
                }
                String cur = input.get(i);
                int num = nums.get(i);
                for (int j = indices[i]; j < num+indices[i]; j++) {
                    if (j >= cur.length()) {
                        System.out.print(" ");
                    } else {
                        System.out.print(cur.charAt(j));
                        if (j+1 >= cur.length()) {
                            outOfBound++;
                        }
                    }
                }
                indices[i] += num;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OutputStrings instance = new OutputStrings();
        List<String> input = new ArrayList<>(Arrays.asList("abcdefg", "abc", "abcde"));
        List<Integer> nums = new ArrayList<>(Arrays.asList(3,3,3));
        instance.printString(input, nums);
    }

}
