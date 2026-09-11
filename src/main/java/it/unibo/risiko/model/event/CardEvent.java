package it.unibo.risiko.model.event;

import java.util.List;

import it.unibo.risiko.model.deck.Card;

/**
 * CardEvent
 */
public record CardEvent(List<Card> played, String name, int armies) implements Event{

    @Override
    public <T> T accept(EventVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
