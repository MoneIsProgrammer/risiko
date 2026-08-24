package it.unibo.risiko.model.event;

import java.util.Map;

/**
 * Event that models the reinforcement of troops in owned territories.
 * 
 * @param player that generated event
 * @param reinforcement maps territory to number of troops to reinforce
 */
public record ReinforceEvent(
    String player,
    Map<String, Integer> reinforcement 
) implements Event {

    /**
     * @param player that generates this event
     * @param reinforcement map of territory with troops to add to each one
     */
    public ReinforceEvent(final String player, final Map<String, Integer> reinforcement) {
        this.player = player;
        this.reinforcement = Map.copyOf(reinforcement);
    }

    /**
     * @return the total troops that are gained in the reinforcement
     */
    public int totalReinforcement() {
        return reinforcement.values().stream().mapToInt(i -> i).sum();
    }

    @Override
    public Map<String, Integer> reinforcement() {
        return Map.copyOf(reinforcement);
    }

    @Override
    public <T> T accept(final EventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
