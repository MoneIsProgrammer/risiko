package it.unibo.risiko.model.player;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * The general implementation of a Player, gives the general methods for the basic actions and methods
 * to ease the implementation of human and bot Players.
 * It's designed so that each player behavior is differentiated by the Strategy Pattern,
 * meaning for each different behavior and external {@link PlayerStrategy} implementation is required.
 */
public interface Player {
    /**
     * @return the strategy used by the player, useful if the strategy requires succesive method calls to build the event
     */
    PlayerStrategy getStrategy();

    /**
     * @return true if the player is human controlled
     */
    boolean isHuman();

    /**
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<AttackEvent> attack();

    /**
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<MoveEvent> move();

    /**
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<ReinforceEvent> reinforce();

}
