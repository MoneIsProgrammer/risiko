package it.unibo.risiko.model.history;

import java.util.List;

import it.unibo.risiko.model.event.Event;

/**
 * Implementation of the Hystory of the game containing various {@link Event}s
 */
public interface History {
    /**
     * @return a List of all Events that happened
     */
    List<Event> getAllEvents();

    /**
     * @param n number of Events in the return list
     * @return the last n Events in the list starting from last-n until last, if n is greater than the total number of events there will be less than n elements
     */
    List<Event> getLastNEvents(int n);

    /**
     * @return the number of events present in History
     */
    int getTotalEvents();

    /**
     * @param event the event to be added to the History
     */
    void addEvent(Event event);
}
