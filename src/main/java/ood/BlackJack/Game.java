package ood.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final Deck deck;

    public Game(int n) { // n >= 2
        this.players = initPlayers(n);
        this.deck = initDeck();
    }

    public List<String> start() {
        List<String> winners = new ArrayList<>();
        int playersLeft = players.size();
        while (!this.deck.isEmpty() && playersLeft > 0) {
            for (Player player : this.players) {
                if (player.isBusted() || player.win()) {
                    continue;
                }
                player.play(deck);
                if (player.win()) {
                    winners.add(player.name());
                    playersLeft--;
                } else if (player.isBusted()) {
                    playersLeft--;
                }
            }
        }
        return winners;
    }

    private List<Player> initPlayers(int n) {
        List<Player> hands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hands.add(new Player("Player" + i));
        }
        return hands;
    }

    private Deck initDeck() {
        return new Deck();
    }

    public static void main(String[] args) {
        Game game = new Game(1);
        System.out.println(game.start());
    }

}
