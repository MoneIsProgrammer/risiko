package it.unibo.risiko.model.event;

import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.Player;

/**
 * Event that models the movement of troops from a owned territory to another, should not be kept as persistent data.
 * 
 * @param player that generated event
 * @param sourceTerritory territory from which troops came from
 * @param destinationTerritory territory where troops will end up
 * @param troopsMoved numbere of troops moved
 */
public record MoveEvent(
    Player player,
    Territory sourceTerritory,
    Territory destinationTerritory,
    int troopsMoved
) implements Event {

    @Override
    public <T> T accept(final EventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
