package it.unibo.risiko.model.player;

import it.unibo.risiko.model.player.strategy.PlayerStrategy;

public interface Player {
    public PlayerStrategy getStrategy();

    public boolean isHuman();
}
