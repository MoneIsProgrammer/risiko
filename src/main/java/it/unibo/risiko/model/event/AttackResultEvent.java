package it.unibo.risiko.model.event;

/**
 * Composition of {@link AttackEvent} where the attack is resolved.
 * 
 * @param attack attack that originated this
 * @param attackerLosses troops lost by attacker
 * @param defenderLosses troops lost by defender
 * @param conquered true if attacker conquered the territory
 */
public record AttackResultEvent(
    AttackEvent attack,
    int attackerLosses,
    int defenderLosses,
    boolean conquered
) implements Event {

    @Override
    public <T> T accept(final EventVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
