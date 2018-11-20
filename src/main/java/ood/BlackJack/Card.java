package ood.BlackJack;


public class Card {

    private final FaceValue faceValue;
    private final Suit suit;

    public Card(Suit suit, FaceValue faceValue) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public FaceValue faceValue() {
        return this.faceValue;
    }

    public Suit suit() {
        return this.suit;
    }

    public boolean isAce() {
        return this.faceValue == FaceValue.A;
    }
}
