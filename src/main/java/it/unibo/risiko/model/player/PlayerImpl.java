package it.unibo.risiko.model.player;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.player.strategy.HumanStrategy;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

public class PlayerImpl implements Player{
    private final String name;
    private final PlayerStrategy strategy;
    private final RisikoColors color;
    //private final Set<Territory> = new HashSet<>();

    protected PlayerImpl(RisikoColors color, String name, PlayerStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.color = color;
    }

    @Override
    public PlayerStrategy getStrategy() {
        return this.strategy;
    }

    @Override
    public boolean isHuman() {
        return this.strategy instanceof HumanStrategy;
    }

    @Override
    public Optional<AttackEvent> attack() {
        return this.strategy.getAttack();
    }

    @Override
    public Optional<MoveEvent> move() {
        return this.strategy.getMove();
    }

    @Override
    public Optional<ReinforceEvent> reinforce() {
        return this.strategy.getReinforce();
    }
    
}
