package it.unibo.risiko.model.event;

import java.util.Map;

/**
 * Event that models the reinforcement of troops in owned territories
 */
public interface ReinforceEvent extends Event{
    /**
     * @return the total troops that are gained in the reinforcement
     */
    int totalReinforcement();

    Map<Territory,Integer> reinforcementPlacement();//Territory to yet be implemented
}
