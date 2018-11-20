package ood.NavalWarfares;

import java.util.List;

public class Player {

    private final String name;
    private final Boat boat;

    public Player(String name, Boat boat) {
        this.name = name;
        this.boat = boat;
    }

    // return the boat destroyed by this attack
    public List<Boat> play(Sea sea) { // 只是在play的时候需要sea的信息，把sea作为参数传进来
        Direction[] directions = Direction.values();
        Direction direction = directions[(int) (Math.random() * 4)];
        this.boat.move(direction);
        return this.boat.fire(sea.getBoats());
    }

    public boolean loses() {
        return this.boat.isDestroyed();
    }
}
