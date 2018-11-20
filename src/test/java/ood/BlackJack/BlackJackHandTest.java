package ood.BlackJack;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BlackJackHandTest {

    private BlackJackHand instance;

    @Before
    public void setUp() {
        instance = new BlackJackHand();
    }

    @Test
    public void addToHand() throws Exception {

    }

    @Test
    public void updateScores() throws Exception {
        Card card = new Card(Suit.Diamond, FaceValue.Eight);
        instance.updateScores(card);

        assertEquals(8, instance.baseScore);
        assertEquals(0, instance.aceNum);
        Set<Integer> expectedSet = new HashSet<>(Collections.singletonList(0));
        assertEquals(expectedSet, instance.variableScores);

        Card card2 = new Card(Suit.Diamond, FaceValue.A);
        instance.updateScores(card2);
        assertEquals(8, instance.baseScore);
        assertEquals(1, instance.aceNum);
        expectedSet = new HashSet<>(Arrays.asList(1, 11));
        assertEquals(expectedSet, instance.variableScores);

        Card card3 = new Card(Suit.Diamond, FaceValue.A);
        instance.updateScores(card3);
        assertEquals(8, instance.baseScore);
        assertEquals(2, instance.aceNum);
        expectedSet = new HashSet<>(Arrays.asList(2, 12, 22));
        assertEquals(expectedSet, instance.variableScores);
    }

    @Test
    public void isBusted() throws Exception {
        Card card = new Card(Suit.Diamond, FaceValue.Eight);
        instance.addToHand(card);
        assertEquals(false, instance.isBusted());

        instance.addToHand(card);
        Card card2 = new Card(Suit.Diamond, FaceValue.A);
        instance.addToHand(card2);
        assertEquals(false, instance.isBusted());

        instance.addToHand(card);
        assertEquals(true, instance.isBusted());

    }

    @Test
    public void isBlackJack() throws Exception {
        instance.addToHand(new Card(Suit.Diamond, FaceValue.Eight));
        instance.addToHand(new Card(Suit.Diamond, FaceValue.Q));
        instance.addToHand(new Card(Suit.Diamond, FaceValue.A));
        assertEquals(true, instance.isBlackJack());
    }

}