package it.unibo.risiko.model.history;

import java.util.LinkedList;
import java.util.List;

import it.unibo.risiko.model.event.Event;

/**
 * Implementation of History.
 */
public class HistoryImpl implements History {

    private final List<Event> history = new LinkedList<>();

    @Override
    public final List<Event> getAllEvents() {
        return List.copyOf(this.history);
    }

    @Override
    public final List<Event> getLastNEvents(final int n) {
        return this.history.stream().limit(n).toList();
    }

    @Override
    public final int getTotalEvents() {
        return this.history.size();
    }

    @Override
    public final void addEvent(final Event event) {
        this.history.add(event);
    }

    @Override
    public final void restoreHistory(final List<Event> newHistory) {
        this.history.clear();
        this.history.addAll(newHistory);
    }
}
