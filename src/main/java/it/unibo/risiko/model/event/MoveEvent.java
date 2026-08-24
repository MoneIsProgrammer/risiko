package it.unibo.risiko.model.event;


/**
 * Event that models the movement of troops from a owned territory to another
 */
public interface MoveEvent extends Event{
    /**
     * @return the Territory from which the troops came from
     */
    void getSource(); // chenge void with territory interface

    /**
     * @return the Territory to where the troops end up
     */
    void getDestination();

    /**
     * @return the number of troops moved from Source to Destination
     */
    int troopsMoved();
}
