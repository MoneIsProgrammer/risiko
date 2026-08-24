package it.unibo.risiko.model.event;

/**
 * Event that models the movement of troops from a owned territory to another.
 * 
 * @param player that generated event
 * @param sourceTerritory territory from which troops came from
 * @param destinationTerritory territory where troops will end up
 * @param troopsMoved numbere of troops moved
 */
public record MoveEvent(
    String player,
    String sourceTerritory,
    String destinationTerritory,
    int troopsMoved
) implements Event {

    @Override
    public <T> T accept(final EventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
