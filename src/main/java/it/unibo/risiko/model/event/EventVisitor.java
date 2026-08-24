package it.unibo.risiko.model.event;

/**
 * The general interface for a visitor of the Visitor Pattern to interact with {@link Event}
 */
public interface EventVisitor<T>{
    /**
     * @param event
     * @return type to be determined in the implementation
     */
    T visit(AttackEvent event);
    
    /**
     * @param event
     * @return type to be determined in the implementation
     */
    T visit(AttackResultEvent event);
    
    /**
     * @param event
     * @return type to be determined in the implementation
     */
    T visit(MoveEvent event);
    
    /**
     * @param event
     * @return type to be determined in the implementation
     */
    T visit(ReinforceEvent event);
}
