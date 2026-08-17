package it.unibo.risiko.mvc.model.event;

public interface Event {
    Event accept(EventVisitor visitor);
}