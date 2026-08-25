package it.unibo.risiko.model.player;

/**
 * The factory that is used to create players with different strategies.
 */
public interface PlayerFactory {
    /**
     * Used to create a player controlled by a human via successive interactions
     * @return human controlled player
     */
    Player createHumanPlayer();

    /**
     * Used to create a computer controlled player who prefers to defend itself
     * @return bot with a defensive strategy
     */
    Player createDefensiveBot();

    /**
     * Used to create a computer controlled player who prefers to attack when able
     * @return bot with an aggressive strategy
     */
    Player createAggressiveBot();

    /**
     * Used to create a computer controlled player where action are taken randomly
     * @return bot with a strategy where actions are chosen at random
     */
    Player createRandomBot();
}
