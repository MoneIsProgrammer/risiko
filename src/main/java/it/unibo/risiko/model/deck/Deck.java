package it.unibo.risiko.model.deck;

/**
 * This is a sub-class, it is a specialized type of the Hand Class
 * Attributes: cards (already inherited from Hand)
 * Methods: populate(), shuffle(), deal(hands, per_hand = n)
 * Deck
 */
public class Deck extends Hand {
    /* We already have a constructor from the Hand class,
    so there's no need to add a constructor here */
    /* In order to populate our deck, we don't need any values, 
    so this is a void method */
    public void populate() {
        /* To populate, we're going to loop through all of our 
        territories and for each territory we'll add one of each troop */
        for (DeckTerritories territoryName: DeckTerritories.values()) {
            for (DeckTroops troopsName: DeckTroops.values()) {
                Card card = new Card(territoryName, troopsName);
                /* Here "this" refers to each individual deck we create */
                this.add(card);
            }
        }
    }
    public void shuffle() {
        /* TODO */
    }
     /* Try adding an option to cut the deck, split the deck (somwehat randomly)
    Take the top half and swap it with the bottom half */
}
