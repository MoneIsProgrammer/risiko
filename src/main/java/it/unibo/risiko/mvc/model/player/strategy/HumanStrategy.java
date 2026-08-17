package it.unibo.risiko.mvc.model.player.strategy;

public interface HumanStrategy {
    public void attackSource();

    public void attackDestination();

    public void attackStrenght();

    public void reinforceStrenght();

    public void reinforceDestination();

    public void moveSource();

    public void moveDestination();

    public void moveStrenght();
}
