package thumbtack;

import java.util.ArrayList;
import java.util.List;

public class AmicableNumbers {

    public static List<List<Integer>> amicableNumbers(int n) {
        /*
        int[n+1] sums, sums[i] = the sum of all proper factors for number i
        for each number
            int other = nums[i]
            if other < num and sums[other] == number
                add this pair to list
            endif
        endfor
         */
        int[] sums = sumOfProperFactors(n);
        List<List<Integer>> results = new ArrayList<>();
        for (int num = 2; num <= n; num++) {
            int other = sums[num];
            if (other < num && sums[other] == num) {
                List<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(other);
                results.add(pair);
            }
        }
        return results;
    }

    private static int[] sumOfProperFactors(int n) {
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                sums[j] += i;
            }
        }
        return sums;
    }
}
