package it.unibo.risiko.model.player.strategy;

/**
 * Strategy designed to be used by human player, models various methods to build each event.
 */
public interface HumanStrategy extends PlayerStrategy {
    /**
     * sets the source of an attack.
     * 
     * @param territory where the attack came from
     */
    void attackSource(String territory);

    /**
     * sets the destination of an attack.
     * 
     * @param territory what territory the attack targets
     */
    void attackDestination(String territory);

    /**
     * sets the number of troops to be used in the attack.
     * 
     * @param strength number of attacker's troops
     */
    void attackStrenght(int strength);

    /**
     * sets the number of troops to reinforce a territory.
     * 
     * @param strength number of defender's troops
     */
    void reinforce(int strength);

    /**
     * sets the source of the movement.
     * 
     * @param territory the source
     */
    void moveSource(String territory);

    /**
     * sets the destination of the movement.
     * 
     * @param territory the destination
     */
    void moveDestination(String territory);

    /**
     * sets how many troops are to be moved from source to dest.
     * 
     * @param strength number of troops used in the movement
     */
    void moveStrenght(int strength);
}
