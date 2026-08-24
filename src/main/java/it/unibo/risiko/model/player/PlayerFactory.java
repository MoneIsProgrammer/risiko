package it.unibo.risiko.model.player;

/**
 * The factory that is used to create players with different strategies.
 */
public interface PlayerFactory {
    /**
     * @return human controlled player
     */
    Player createHumanPlayer();

    /**
     * @return bot with a defensive strategy
     */
    Player createDefensiveBot();

    /**
     * @return bot with an aggressive strategy
     */
    Player createAggressiveBot();

    /**
     * @return bot with a strategy where actions are chosen at random
     */
    Player createRandomBot();
}
