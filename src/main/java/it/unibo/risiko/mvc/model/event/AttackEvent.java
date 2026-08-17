package it.unibo.risiko.mvc.model.event;

import it.unibo.risiko.mvc.model.player.Player;

/**
 * AttackEvent
 */
public interface AttackEvent extends Event{
    public Player getAttacker();

    public Player getDefender();

    public int getAttackerStrenght();

    public int getDefenderStrenght();

    public void getAttackSource();

    public void getAttackDestination();//replace void di territories
}
