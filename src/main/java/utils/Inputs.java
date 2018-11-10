package utils;

import java.util.ArrayList;
import java.util.List;

public class Inputs {

    public static List<List<Integer>> toList(int[][] input) {
        List<List<Integer>> results = new ArrayList<>();
        for (int[] array : input) {
            List<Integer> list = new ArrayList<>();
            for (int num : array) {
                list.add(num);
            }
            results.add(list);
        }
        return results;
    }
}
