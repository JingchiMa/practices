package ood.NavalWarfares;

import java.util.ArrayList;
import java.util.List;

public class Boat {

    private static final int RANGE = 3;
    private static final int SPEED = 1;
    private static final int ATTACK = 10;
    private final String name;

    private int health = 100;
    private Point location = Point.random();

    public Boat(String name) {
        this.name = name;
    }

    // return the damaged boats
    public List<Boat> fire(List<Boat> boats) { // 只是在fire的时候需要其他船的信息，所以把boats作为参数传进来
        List<Boat> damageds = new ArrayList<>();
        for (Boat boat : boats) {
            if (boat == this) { // 我生气起来连自己都打！！！
                continue;
            }
            if (withinRange(boat)) {
                boat.damage(ATTACK);
                if (boat.isDestroyed()) {
                    damageds.add(boat);
                }
            }
        }
        return damageds;
    }

    private void damage(int attack) {
        this.health -= attack;
    }

    public void move(Direction direction) {
        switch(direction) {
            case Up:
                location.y += SPEED;
                break;
            case Down:
                location.y -= SPEED;
                break;
            case Left:
                location.x -= SPEED;
                break;
            case Right:
                location.x += SPEED;
                break;
        }
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.health + " " + this.location;
    }

    // infinity norm
    private boolean withinRange(Boat boat) {
        return Math.abs(boat.location.x - this.location.x) <= RANGE
                && Math.abs(boat.location.y - this.location.y) <= RANGE;
    }
}
