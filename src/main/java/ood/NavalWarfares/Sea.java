package ood.NavalWarfares;

import java.util.ArrayList;
import java.util.List;

public class Sea {

    private List<Boat> boats = new ArrayList<>();

    public Sea() {

    }

    public void add(Boat boat) {
        boats.add(boat);
    }

    public List<Boat> getBoats() {
        return boats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boat boat : boats) {
            sb.append(boat).append(" ");
        }
        return sb.toString();
    }
}
