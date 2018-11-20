package ood.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards = fullCards();
    private int end; // exclusive

    public Deck() {
        this.end = cards.size();
    }

    // dealCard a card from the deck. Assume always dealCard from the end
    public Card dealCard() {
        if (isEmpty()) {
            return null;
        }
        Card drawnCard = cards.get(end - 1);
        end--;
        return drawnCard;
    }

    // add a card back to deck. Assume always add at the end
    public void add(Card card) {
        // always allow adding cards
        cards.add(card);
        end++;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public int size() {
        return end;
    }

    private List<Card> fullCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : FaceValue.values()) {
                cards.add(new Card(suit, faceValue));
            }
        }
        shuffle(cards);
        return cards;
    }

    private void shuffle(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            int chosen = (int) (Math.random() * (cards.size() - i) + i);
            swap(cards, i, chosen);
        }
    }

    private void swap(List<Card> cards, int i, int j) {
        Card tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }

}
