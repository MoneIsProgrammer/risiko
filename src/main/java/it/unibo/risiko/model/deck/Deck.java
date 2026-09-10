package it.unibo.risiko.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This is a super class. It forms the basis of all decks including 
 * territories deck and objectives deck
 * Attributes: cards
 * Methods: clear(), add(card), remove(card), shuffle()
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
}
