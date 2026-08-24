package it.unibo.risiko.model.event;

/** 
 * Event that models the intent of a player to attack another.
 *
 * @param attacker the attacker
 * @param defender   the victim
 * @param attackerStrength troops used by attacker
 * @param defenderStrength troops defending
 * @param attackSource territory where the attack came
 * @param attackDestination destination territory of attack
 */
public record AttackEvent(
    String attacker,
    String defender,
    int attackerStrength,
    int defenderStrength,
    String attackSource,
    String attackDestination
) implements Event {

    @Override
    public <T> T accept(final EventVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
