package it.unibo.risiko.model.event;

import it.unibo.risiko.model.player.Player;

/**
 * The general concept of event that implements the Visitor Pattern "entrance"
 */
public interface Event {
    
    /**
     * @return the player that generated the event
     */
    Player getPlayer();
    
    /**
     * @param <T> generic so {@link EventVisitor} can have different return types depending on implementation
     * @param visitor the iplementation of {@link EventVisitor}
     * @return the element defined by {@link EventVisitor} implementation
     */
    <T> T accept(EventVisitor<T> visitor);
}