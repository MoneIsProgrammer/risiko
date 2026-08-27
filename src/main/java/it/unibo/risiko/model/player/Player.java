package it.unibo.risiko.model.player;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * The general implementation of a Player, gives the general methods for the basic actions and methods.
 * to ease the implementation of human and bot Players.
 * It's designed so that each player behavior is differentiated by the Strategy Pattern,
 * meaning for each different behavior and external {@link PlayerStrategy} implementation is required.
 */
public interface Player {
    /**
     * Returns the Strategy used by the player.
     * 
     * @return the strategy used by the player, useful if the strategy requires succesive method calls to build the event
     */
    PlayerStrategy getStrategy();

    /**
     * If the player is controlled by a human returns true, else returns false.
     * 
     * @return true if the player is human controlled
     */
    boolean isHuman();

    /**
     * Used to get the next attack that the player wants to take.
     * 
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<AttackEvent> attack();

    /**
     * Used to get the transfer of troops from a territory to another.
     * 
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<MoveEvent> move();

    /**
     * Used to get the reinforcement to various territories.
     * 
     * @return an {@link Optional} containing the event if it can be generated, {@link Optional#empty()} otherwise
     */
    Optional<ReinforceEvent> reinforce();

}
