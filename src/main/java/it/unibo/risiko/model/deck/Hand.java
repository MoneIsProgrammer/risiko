package it.unibo.risiko.model.deck;

import java.util.ArrayList;

/**
 * This is a super class. It forms the basis of all handds including deck
 * Attributes: cards
 * Methods: clear(), add(card), remove(card), give(card, otherHand), showHand()
 */
public class Hand {
    private ArrayList<Card> cards;

    // Constructor
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /*  To clear the hand and the cards in hand */
    public void clear() {
        cards.clear();
    }

    /* To add a card to a hand*/
    public void add(Card card) {
        cards.add(card);
    }

    /* To remove a card from a hand */
    public void remove(Card card) {
        cards.remove(card);
    }

    /* To show hand */
    public String showHand() {
        String str = "";

        /* We are going to loop through a hand and
        add the values of each card to the string */
        for (Card c: cards) {
            str += c.toString() + "\n";
        }
        return str;
    }

    /* Give a card by removing said card from the hand.
    First we need to know which card we are giving and 
    who are we giving it to (i.e. otherHand) */ 
    public boolean give(Card card, Hand otherHand) {
        /* which is why we check whether we have said card,
        if we don't have the card, we are going to return false
        and do nothing else
        otherwise if we do have said card, we are going to remove
        it as an object */
        if (!cards.contains(card)) {
            return false;
        } else {
            // Resolve ASAP card.remove(card);
            otherHand.add(card);
            return true;
        }
    }
}
