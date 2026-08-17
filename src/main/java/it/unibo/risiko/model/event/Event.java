package it.unibo.risiko.model.event;

public interface Event {
    Event accept(EventVisitor visitor);
}