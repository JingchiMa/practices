package interviews.Houzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QueryCounterServiceTest {

    private QueryCounterService instance = new QueryCounterService();

    @Test
    public void test() {
//        int[] ops = {0, 0, 0, 2, 1, 0, 0, 0, 2};
//        String[] params = {"q1", "q1", "q2", "2", "q1", "q3", "q3", "q3", "2"};
//        execute(ops, params);

        int[] ops = {0, 0, 0, 0, 0};
        String[] params = {"q1", "q1", "q2", "q3", "q3"};
        execute(ops, params);
    }

    private List<List<String>> execute(int[] ops, String[] params) {
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case 0:
                    instance.addCount(params[i]);
                    break;
                case 1:
                    System.out.println(instance.getCount(params[i]));
                    break;
                case 2:
                    List<String> subRes = instance.getTopKFrequentQueries(Integer.parseInt(params[i]));
                    System.out.println(subRes);
                    results.add(subRes);
            }
        }
        return results;
    }
}