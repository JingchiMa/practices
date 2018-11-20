package ood.NavalWarfares;

import java.util.ArrayList;
import java.util.List;

public class NavalWarfareGame {

    private static final int MAX_TURNS = 10;

    private List<Player> players = new ArrayList<>();
    private Sea sea = new Sea();


    public NavalWarfareGame(int number) {
        init(number);
    }

    private void init(int number) {
        for (int i = 0; i < number; i++) {
            Boat boat = new Boat("player" + i);
            sea.add(boat);
            Player player = new Player("player" + i, boat);
            players.add(player);
        }
    }

    public void start() {
        System.out.println(this.sea);
        for (int turn = 0; turn < MAX_TURNS; turn++) {
            for (Player player : players) {
                if (player.loses()) {
                    continue;
                }
                System.out.println(player.play(this.sea));
                System.out.println(this.sea);
            }
        }
    }

    public static void main(String[] args) {
        NavalWarfareGame game = new NavalWarfareGame(2);
        game.start();
    }
}
