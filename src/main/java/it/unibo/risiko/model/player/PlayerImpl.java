package it.unibo.risiko.model.player;

import java.util.Optional;
import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.player.strategy.HumanStrategy;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * PlayerImpl implementation of Player.
 */
public final class PlayerImpl implements Player {
    private final String name;
    private final PlayerStrategy strategy;
    private final RisikoColors color;
    private final String id;

    /**
     * Can only be created from {@link PlayerFactory} following a request.
     * 
     * @param color of the player
     * @param name  name of the player
     * @param strategy  strategy that this player will use during its turns
     */
    protected PlayerImpl(final RisikoColors color, final String name, final PlayerStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
        this.color = color;
        this.id = color + name;

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
    public Optional<AttackEvent> attack(GameMap map) {
        return this.strategy.getAttack(this);
    }

    @Override
    public Optional<MoveEvent> move(GameMap map) {
        return this.strategy.getMove(null);
    }

    @Override
    public Optional<ReinforceEvent> reinforce(GameMap map) {
        return this.strategy.getReinforce(null);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override 
    public RisikoColors getColor() {
        return color;
    }

}
