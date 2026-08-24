package it.unibo.risiko.model.event;

import it.unibo.risiko.model.player.Player;

/**
 * Event that mododels the intent of a player to attack another
 */
public interface AttackEvent extends Event{
    /**
     * @return the player that intends to attack
     */
    public Player getAttacker();

    /**
     * @return the player that is being attacked
     */
    public Player getDefender();

    /**
     * @return the number of troops used for the attack
     */
    public int getAttackerStrenght();

    /**
     * @return the number of troops used to defend 
     */
    public int getDefenderStrenght();

    /**
     * @return the territory from where the attack came from
     */
    public void getAttackSource();

    /**
     * @return the territory targeted by the attack
     */
    public void getAttackDestination();//replace void di territories
}
