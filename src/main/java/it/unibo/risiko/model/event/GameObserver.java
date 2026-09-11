package it.unibo.risiko.model.event;

/**
 * Implemented by whoever wants to be told about what happens during a game.
 * The events by themselves don't notify anybody, the history just keeps them in a list,
 * so this is what lets the panels redraw on their own.
 * The model doesn't know who the observers are, it only calls them back.
 */
@FunctionalInterface
public interface GameObserver {

    /**
     * called when something happened in the game, always on the graphics thread.
     *
     * @param event the event that just happened
     */
    void onEvent(Event event);
}
