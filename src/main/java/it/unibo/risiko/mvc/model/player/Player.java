package it.unibo.risiko.mvc.model.player;

import it.unibo.risiko.mvc.model.player.strategy.PlayerStrategy;

public interface Player {
    public PlayerStrategy getStrategy();

    public boolean isHuman();
}
