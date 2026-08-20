package it.unibo.risiko.model.event;

/**
 * EventVisitor
 */
public interface EventVisitor{
    <T> T visit(AttackEvent event);

    <T> T visit(AttackResultEvent event);

    <T> T visit(MoveEvent event);

    <T> T visit(ReinforceEvent event);
}
