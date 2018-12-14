package interviews.Houzz;

import java.util.*;

public class PrimeFactors {
    public List<Integer> generatePrimeFactors(int num) {
        if (num <= 0) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>();
        while (num % 2 == 0) {
            results.add(2);
            num /= 2;
        }
        while (true) {
            int size = results.size();
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    results.add(i);
                    num /= i;
                }
            }
            if (size == results.size()) {
                break;
            }
        }
        if (num != 1) {
            results.add(num);
        }
        return results;
    }

    // follow-up 1:
    public String generatePrimeFactorsInPower(int num) {
        if (num <= 0) {
            return "";
        }
// map the factor to its power
        Map<Integer, Integer> powers = new HashMap<>();
        while (num % 2 == 0) {
            int power = powers.getOrDefault(2, 0);
            powers.put(2, power + 1);
            num /= 2;
        }
        boolean haveFactors = true;
        while (haveFactors) {
            haveFactors = false;
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    int power = powers.getOrDefault(i, 0);
                    powers.put(i, power + 1);
                    num /= i;
                    haveFactors = true;
                }
            }
        }
        if (num != 1) {
            powers.put(num, powers.getOrDefault(num, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : powers.entrySet()) {
            if (entry.getValue() == 1) {
                res.append(entry.getKey()).append("*");
            } else {
                res.append(entry.getKey()).append("^").append(entry.getValue()).append("*");
            }
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }


    // follow-up 2: 5 * 2^2
    public String generatePrimeFactorsInReverseOrder(int num) {
        if (num <= 0) {
            return "";
        }
// map the factor to its power
        Map<Integer, Integer> powers = new HashMap<>();
        while (num % 2 == 0) {
            int power = powers.getOrDefault(2, 0);
            powers.put(2, power + 1);
            num /= 2;
        }
        boolean haveFactors = true;
        while (haveFactors) {
            haveFactors = false;
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    int power = powers.getOrDefault(i, 0);
                    powers.put(i, power + 1);
                    num /= i;
                    haveFactors = true;
                }
            }
        }
        if (num != 1) {
            powers.put(num, powers.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        entries.addAll(powers.entrySet());
        entries.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return entry2.getKey() - entry1.getKey();
            }
        });
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                res.append(entry.getKey()).append("*");
            } else {
                res.append(entry.getKey()).append("^").append(entry.getValue()).append("*");
            }
        }
        res.deleteCharAt(res.length()-1); // don't forget to delete the redundant *
        return res.toString();
    }


}
