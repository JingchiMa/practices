package interviews.Houzz;

import java.util.*;

public class CrossProductIterator {

    private boolean hasNext;
    private int[] indices;
    private List<List<Character>> input;

    CrossProductIterator(List<List<Character>> input) {
        hasNext = true;
        indices = new int[input.size()];
        this.input = input;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            sb.append(input.get(i).get(indices[i]));
        }
        int index = indices.length - 1;
        while (index >= 0) {
            if (indices[index] < input.get(index).size() - 1) {
                indices[index]++;
                hasNext = true;
                break;
            }
            indices[index] = 0;
            index--;
        }
        if (index < 0) {
            hasNext = false;
        }
        return sb.toString();
    }
}

