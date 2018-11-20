package ood.BlackJack;

import java.util.*;

public class BlackJackHand {

    private static final int BUSTED_SCORE = 22;
    private static final int TARGET_SCORE = 21;

    private final List<Card> cards = new ArrayList<>();

    // expose the following for easier tests
    int baseScore = 0;
    int aceNum = 0;
    Set<Integer> variableScores = new HashSet<>(Collections.singletonList(0));

    public BlackJackHand() {}

    public void addToHand(Card card) {
        cards.add(card);
        updateScores(card);
    }

    void updateScores(Card card) {
        if (card.isAce()) {
            aceNum++;
            Set<Integer> newScores = new HashSet<>();
            for (Integer score : variableScores) {
                newScores.add(score + 1); // TODO: use variable instead
                newScores.add(score + 11);
            }
            variableScores = newScores;
        } else {
            baseScore += card.faceValue().getValue();
        }
    }

    public boolean isBusted() { // min score
        return baseScore + aceNum >= BUSTED_SCORE;
    }

    public boolean isBlackJack() {
        return variableScores.contains(TARGET_SCORE - baseScore);
    }
}
