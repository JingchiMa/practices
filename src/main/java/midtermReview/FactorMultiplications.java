package midtermReview;

import java.util.ArrayList;
import java.util.List;

public class FactorMultiplications {

    public List<List<Integer>> allPossibleFactors(int target) {
        if (target == 1) {
            return new ArrayList<>();
        }
        List<Integer> factors = getFactors(target);
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, factors, target, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int index, List<Integer> factors, int target,  List<Integer> path, List<List<Integer>> results) {
        if (index == factors.size()) {
            if (target == 1) {
                results.add(new ArrayList<>(path));
            }
            return;
        }
        // forgot to consider the case where we choose not to use the current number
        dfs(index + 1, factors, target, path, results);
        int size = path.size();
        for (int num = factors.get(index); target % num == 0; num *= factors.get(index)) {
            path.add(factors.get(index));
            dfs(index + 1, factors, target / num, path, results);
        }
        while (path.size() > size) {
            path.remove(path.size() - 1);
        }
    }

    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= target / 2; i++) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

}
