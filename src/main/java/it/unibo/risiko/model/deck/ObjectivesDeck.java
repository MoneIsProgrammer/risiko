package it.unibo.risiko.model.deck;

public class ObjectivesDeck extends Deck {
    /**
     * This deck will be the collection of all the objective cards
     */
    ObjectivesDeck deckObjectiveCards = new ObjectivesDeck();

    /* Creates a deck with all the objective cards */
    void createObjectiveDeck() {
        deckObjectiveCards.populateObjectiveDeck();
        deckObjectiveCards.shuffle();
    }

    /* Getter */
    ObjectivesDeck getObjectivesDeck() {
        return deckObjectiveCards;
    }
}
