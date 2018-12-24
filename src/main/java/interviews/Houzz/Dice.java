package interviews.Houzz;

public class Dice {

    // return the probability of getting target using index times
    double dfs(int index, int target) {
        if (index == 0) { // edge case
            return 0;
        }
        if (index == 1) {
            if (target >= 1 && target <= 6) {
                return (double) 1 / 6;
            }
            return 0;
        }
        double prob = 0;
        for (int i = 1; i <= 6; i++) {
            double subProb = dfs(index - 1, target - i);
            prob += subProb * 1 / 6;
        }
        return prob;
    }
}
