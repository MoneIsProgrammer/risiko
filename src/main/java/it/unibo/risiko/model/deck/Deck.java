package it.unibo.risiko.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This is a super class. It forms the basis of all decks including 
 * territories deck and objectives deck
 * Attributes: cards
 * Methods: clear(), add(card), remove(card), shuffle(), 
 * give(card, otherHand), showHand()
 */
public class Deck {
    private ArrayList<Card> cards;
    private final Random random = new Random();

    /* Constructor */
    public Deck() {
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

    /* To shuffle the cards */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /* Function that returns a random value from the enum CardTroops */
    CardTroops getRandomTroop() {
        return (CardTroops.values()[random.nextInt(CardTroops.values().length)]);
    }

    /* In order to populate our deck, we don't need any values, 
    so this is a void method */
    public void populateTerritoryDeck() {
        /* To populate, we're going to loop through all of our 
        territories and for each territory we'll add a random troop 
        using the getRandomTroop() */
        for (CardTerritories territoryName: CardTerritories.values()) {
                Card card = new Card(territoryName, getRandomTroop());
                /* Here "this" refers to each individual deck we create */
                this.add(card);
        }
    }

    /* Adds two jolly cards to our territories deck */
    public void addJolly() {
        /* We'll add two jolly cards to the territories deck, they must have
         all three symbols (cannon, infantry and cavalry) */
        Card cj1 = new Card();
        Card cj2 = new Card();
        this.add(cj1);
        this.add(cj2);
    }

    /* Populate the objectives deck */
    public void populateObjectiveDeck() {
        for (CardObjectives objectiveDescription: CardObjectives.values()) {
            Card card = new Card(objectiveDescription);
            this.add(card);
        }
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
    public boolean give(Card card, Deck otherHand) {
        /* which is why we check whether we have said card,
        if we don't have the card, we are going to return false
        and do nothing else
        otherwise if we do have said card, we are going to remove
        it as an object */
        if (!cards.contains(card)) {
            return false;
        } else {
            // FIXME: Resolve ASAP card.remove(card);
            otherHand.add(card);
            return true;
        }
    }

    /** Calculates the total points of a player
    * The boolean @param hasSetCannons is set to true if the player has 3 cards 
    * with cannons which adds 4 points to his total.
    * The boolean @param hasSetInfantry is set to true if the player has 3 cards
    * with infantry which adds 6 points to his total.
    * The boolean @param hasSetCavalry is set to true if the player has 3 cards 
    * with cavalry which adds 8 points to his total.
    * The boolean @param hasOneEach is set to true if the player has one of 
    * each (Cannon, Infantry and Cavalry) which adds 10 points to his total.
    * The boolean @param hasJollyDuo is set to true if the player has one Jolly card 
    * and 2 cards with same troops (2 cannons or 2 infantry or 2 cavalry) which 
    * adds 12 points to his total */
    public int getTotal() {
        int totalsPts = 0;
        boolean hasSetCannons = false;
        boolean hasSetInfantry = false;
        boolean hasSetCavalry = false;
        boolean hasOneEach = false;
        boolean hasJollyDuo = false;
        
        for (int i = 0; i < cards.size(); i++) {
            //totalsPts += cards.get(i).getTroopValue();
        }
        return totalsPts;
    }
}
