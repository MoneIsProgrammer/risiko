package it.unibo.risiko.mvc.model.event;

public interface AttackResultEvent extends AttackEvent{
    public int getAttackerLosses();

    public int getDefenderLosses();

    public boolean conquestHappened();
}
