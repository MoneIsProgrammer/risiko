package it.unibo.risiko.model.common;

/**
 * Something in the game that has a textual id: territories, continents, players, cards.
 * Ids are strings and not object references so the model packages don't have to know each other.
 */
//not meant to be used as a lambda, it says what the object is and not what it does
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface Identifiable {

    /**
     * The id of the element, it never changes during a game.
     *
     * @return the id of the element
     */
    String getId();
}
