package it.unibo.risiko.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.AttackResultEvent;
import it.unibo.risiko.model.event.EventVisitor;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;

/**
 * EventStringVisitor visitor to get descriptive strings for the events.
 */
public final class EventStringVisitor implements EventVisitor<List<String>> {

    @Override
    public List<String> visit(final AttackEvent event) {
        final String out = event.attacker() + " attacks "
        + event.defender()
        + " from " + event.attackSource()
        + " with " + event.attackerStrength() 
        + " troops to " + event.attackDestination()
        + " defending with " + event.defenderStrength() + " units";
        return List.of(out);
    }

    @Override
    public List<String> visit(final AttackResultEvent event) {
        final String attacker = event.attack().attacker() + " lost " + event.attackerLosses() + " troops";
        final String defender = event.attack().defender() + " lost " + event.defenderLosses() + " troops";
        if (event.conquered()) {
            final String conquered = event.attack().attacker() + " conquered " + event.attack().attackDestination();
            return List.of(attacker, defender, conquered);
        }
        return List.of(attacker, defender);
    }

    @Override
    public List<String> visit(final MoveEvent event) {
        final String out = event.player() 
        + " moved " + event.troopsMoved() 
        + " troops from " + event.sourceTerritory() 
        + " to " + event.destinationTerritory();
        return List.of(out);
    }

    @Override
    public List<String> visit(final ReinforceEvent event) {
        final List<String> out = new ArrayList<>();
        for (final Entry<String, Integer> entry : event.reinforcement().entrySet()) {
            out.add(event.player() + " added " + entry.getValue() + " troops to " + entry.getKey());
        }
        return List.copyOf(out);
    }

}
