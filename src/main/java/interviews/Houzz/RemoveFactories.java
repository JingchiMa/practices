package interviews.Houzz;

import java.util.ArrayList;
import java.util.List;

public class RemoveFactories {
    List<Integer> removeFactories(int[] array, int range) {
        int cur = -range - 1;
        List<Integer> indices = new ArrayList<>();
        while (cur + range < array.length - 1) {
            int next = Math.min(cur + 2 * range + 1, array.length - 1);
            while (next > cur && next >= 0 && array[next] == 0) {
                next--;
            }
            if (next <= cur || next < 0) {
                return new ArrayList<>();
            }
            indices.add(next);
            cur = next;
        }
        return indices;
    }

}
