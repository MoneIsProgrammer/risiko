package it.unibo.risiko.model.player.strategy;

/**
 * Strategy designed to be used by human player, models various methods to build each event
 */
public interface HumanStrategy extends PlayerStrategy{
    /**
     * sets the source of an attack
     */
    public void attackSource();

    /**
     * sets the destination of an attack
     */
    public void attackDestination();

    /**
     * sets the number of troops to be used in the attack
     */
    public void attackStrenght();

    /**
     * sets the number of troops to reinforce a territory
     * @param strenght number of troops
     * @param territory the destination of the reinforce
     */
    public void reinforce(int strenght);

    /**
     * sets the soruce of the movement
     * @param territory the source
     */
    public void moveSource();

    /**
     * sets the destination of the movement
     * @param territory the destination
     */
    public void moveDestination();

    /**sets how many troops are to be moved from source to dest
     * @param strenght number of troops used in the movement
     */
    public void moveStrenght();
}
