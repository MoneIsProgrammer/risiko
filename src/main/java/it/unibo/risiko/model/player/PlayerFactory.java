package it.unibo.risiko.model.player;

public interface PlayerFactory {
    Player createHumanPlayer();

    Player createDefensiveBot();

    Player createAggressiveBot();

    Player createRandomBot();
}
