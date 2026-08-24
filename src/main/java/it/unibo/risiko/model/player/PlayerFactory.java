package it.unibo.risiko.model.player;

/**
 * The factory that is used to create players with different strategies
 */
public interface PlayerFactory {
    Player createHumanPlayer();

    Player createDefensiveBot();

    Player createAggressiveBot();

    Player createRandomBot();
}
