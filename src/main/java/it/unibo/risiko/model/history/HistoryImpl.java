package it.unibo.risiko.model.history;

import java.util.LinkedList;
import java.util.List;

import it.unibo.risiko.model.event.Event;

public class HistoryImpl implements History{

    List<Event> history = new LinkedList<>();

    @Override
    public List<Event> getAllEvents() {
        return List.copyOf(this.history);
    }

    @Override
    public List<Event> getLastNEvents(int n) {
        return this.history.stream().limit(n).toList();
    }

    @Override
    public int getTotalEvents() {
        return this.history.size();
    }

    @Override
    public void addEvent(Event event) {
        this.history.add(event);
    }

    @Override
    public void restoreHistory(List<Event> history) {
        this.history.clear();
        this.history.addAll(history);
    }
    
}
