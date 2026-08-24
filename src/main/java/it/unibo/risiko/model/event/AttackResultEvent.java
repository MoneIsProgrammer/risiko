package it.unibo.risiko.model.event;

/**
 * Extension of {@link AttackEvent} where the attack is resolved
 */
public interface AttackResultEvent extends AttackEvent{
    
    /**
     * @return the number of troops that the attacker lost in the attack
     */
    public int getAttackerLosses();

    /**
     * @return the number of troops that the defender lost in the attack
     */
    public int getDefenderLosses();

    /**
     * @return true if the attack resulted in the attacker taking over the defenter territory
     */
    public boolean conquestHappened();
}
