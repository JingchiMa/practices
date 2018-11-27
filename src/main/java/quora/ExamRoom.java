package quora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExamRoom {

    List<Integer> seated = new ArrayList<>(); // arraylist may not be the best choice
    int N;
    public ExamRoom(int N) {
        this.N = N;
    }

    public int seat() {
        if (seated.isEmpty()) {
            seated.add(0);
            return 0;
        }
        int distance = seated.get(0) - 0;
        int seat = 0;
        int index = 0;
        for (int i = 1; i < seated.size(); i++) {
            int curSeat = (seated.get(i-1) + seated.get(i)) / 2;
            if (curSeat - seated.get(i-1) > distance) {
                seat = curSeat;
                distance = curSeat - seated.get(i-1);
                index = i;
            }
        }
        if (N - 1 - seated.get(seated.size() - 1) > distance) {
            seat = N - 1;
            index = seated.size();
        }
        seated.add(index, seat);
        System.out.println(seated);
        return seat;
    }

    public void leave(int p) {
        Iterator<Integer> iterator = seated.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == p) {
                iterator.remove();
                break;
            }
        }
        System.out.println(seated);
    }
}
