package it.unibo.risiko.model.deck;

/**
 * This is a sub-class, it is a specialized type of the Hand Class
 * Attributes: cards (already inherited from Hand)
 * Methods inherited from Hand: populate(), shuffle()
 * 
 * The purpose of this class is to create a Deck with 
 * all the territory cards
 **/
public class TerritoriesDeck extends Hand {

    /** This deck will be the collection of all the territory cards,
    with eventually added Jolly cards after the Preparation Phase **/
    TerritoriesDeck deckTerritoryCards = new TerritoriesDeck();

    /* Create the deck with all the territory cards */
    void createDeck () {
        deckTerritoryCards.populate();
        deckTerritoryCards.shuffle();
    }

    /* Add the Jolly cards to the deck that already contains all
    the territory cards */
    void addJollyDeck () {
        deckTerritoryCards.addJolly();
        deckTerritoryCards.shuffle();
    }

    /* Getter */
    TerritoriesDeck getDeck () {
        return deckTerritoryCards;
    }
    
}
