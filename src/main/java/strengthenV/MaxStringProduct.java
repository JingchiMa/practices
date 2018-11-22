package strengthenV;

import java.util.*;

public class MaxStringProduct {
    // assumption: length of inputs >= 2
// each string in the list is not null
    public List<String> findStringPair(List<String> inputs) {
        // step 1: sort the input based on length
        Collections.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        }.reversed());

        Map<String, Integer> bitMasks = buildBitMask(inputs);
        // step 2: do bfs
        // start position: <0, 1>
        // expand / generate rule:
        // expand <i, j>, check if it’s valid
        // generate <i + 1, j> and <i, j+1> if it haven’t visited that
        // termination condition
        // if <i, j> is valid, or nothing in the queue anymore
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> start = new ArrayList<>(Arrays.asList(0,1));
        queue.offer(start);
        Set<List<Integer>> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int i = cur.get(0);
            int j = cur.get(1);
            if (!haveSameCharacter(inputs.get(i), inputs.get(j), bitMasks)) {
                return new ArrayList<>(Arrays.asList(inputs.get(i), inputs.get(j)));
            }
            if (i + 1 < inputs.size() && i + 1 != j) {
                List<Integer> next = new ArrayList<>(Arrays.asList(i+1, j));
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
            if (j + 1 < inputs.size() && j + 1 != i) {
                List<Integer> next = new ArrayList<>(Arrays.asList(i, j+1));
                if (!visited.contains(next)) {
                    queue.offer(next);
                }
            }
        }
        return new ArrayList<>(); // no result
    }

    private boolean haveSameCharacter(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean haveSameCharacter(String s1, String s2, Map<String, Integer> bitMasks) {
        int bitMask1 = bitMasks.get(s1);
        int bitMask2 = bitMasks.get(s2);
        return (bitMask1 & bitMask2) != 0;
    }

    private Map<String, Integer> buildBitMask(List<String> strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                mask |= (1 << ((int)s.charAt(i)));
            }
            map.put(s, mask);
        }
        return map;
    }


}
