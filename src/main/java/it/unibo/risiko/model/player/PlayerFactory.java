package it.unibo.risiko.model.player;

/**
 * The factory that is used to create players with different strategies.
 */
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface PlayerFactory {
    /**
     * @param playerRequest necessary informations to build the player
     * @return the player built following specifications
     */
    Player generatePlayer(PlayerRequest playerRequest);
}
