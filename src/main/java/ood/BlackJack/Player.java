package ood.BlackJack;

public class Player {

    private final String name;
    private BlackJackHand blackJackHand;

    public Player(String name) {
        this.name = name;
        this.blackJackHand = new BlackJackHand();
    }

    public void play(Deck deck) {
        int drawCard = (int) (Math.random() * 2);
        if (drawCard == 0) {
            Card card = deck.dealCard();
            if (card != null) {
                this.blackJackHand.addToHand(card);
            }
        }
    }

    public boolean win() {
        return this.blackJackHand.isBlackJack();
    }

    public boolean isBusted() {
        return this.blackJackHand.isBusted();
    }

    public String name() {
        return this.name;
    }
}
