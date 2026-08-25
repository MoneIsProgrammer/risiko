package it.unibo.risiko.model.event;

/**
 * The general concept of event that implements the Visitor Pattern "entrance".
 */
@FunctionalInterface
public interface Event {
    /**
     * The entry point for the visitor pattern, just call {@param visitor } and pass this
     * @param <T> generic so {@link EventVisitor} can have different return types depending on implementation
     * @param visitor the iplementation of {@link EventVisitor}
     * @return the element defined by {@link EventVisitor} implementation
     */
    <T> T accept(EventVisitor<T> visitor);
}
