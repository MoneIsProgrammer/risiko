package it.unibo.risiko.model.player.strategy.ai;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.Player;
import it.unibo.risiko.model.player.Roster;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;
import it.unibo.risiko.model.player.strategy.StrategyUtils;

/**
 * Player strategy where the ai takes decisions randomly.
 */
public class RandomStrategy implements PlayerStrategy {


    private final Roster roster;
    private final GameMap map;
    private final Random random;

    public RandomStrategy(Roster roster, GameMap map) {
        this.roster = roster;
        this.map = map;
        this.random = new Random();
    }

    public RandomStrategy(Roster roster, GameMap map, long seed) {
        this.roster = roster;
        this.map = map;
        this.random = new Random(seed);
    }

    @Override
    public Optional<AttackEvent> getAttack(Player owner) {
        if (this.random.nextInt(10) % 3 == 0) {
            return Optional.empty();
        }
        var playerTerritories = map.getTerritoriesOf(owner.getId());
        var border = StrategyUtils.getBorderTerritories(playerTerritories, this.map);
        var attacker = border.stream().filter(a -> a.getArmies() > 1).findAny();
        if (attacker.isEmpty()) {
            return Optional.empty();
        }
        var victim = attacker.get().getAdjacentIds().stream()
        .map(a -> this.map.getTerritory(a))
        .filter(a -> !a.getOwnerId().get().equals(owner.getId()))
        .findAny();
        return Optional.of(new AttackEvent(owner,
            this.roster.getPlayer(victim.get().getOwnerId().get()),
            attacker.get().getArmies() > 3 ? 3 : attacker.get().getArmies() - 1,
            victim.get().getArmies() > 3 ? 3 : victim.get().getArmies(),
            attacker.get(),
            victim.get()
        ));
    }

    @Override
    public Optional<MoveEvent> getMove(Player owner) {
        if (this.random.nextInt(3) == 0) {
            return Optional.empty();
        }
        var playerTerritories = this.map.getTerritoriesOf(owner.getId());//TODO fix movement only in adj territories
        var source = playerTerritories.stream().findAny();
        var destination = playerTerritories.stream().findAny();
        if (source.isEmpty()|| destination.isEmpty() || source.get().getArmies() < 3) {
            return Optional.empty();
        }
        var moveStr = this.random.nextInt(1, source.get().getArmies());
        return Optional.of(new MoveEvent(owner,source.get(),destination.get(),moveStr));
    }

    @Override
    public Optional<ReinforceEvent> getReinforce(Player owner) {
        Map<Territory,Integer> reinforceMap = new HashMap<>();
        var playerTerritories = this.map.getTerritoriesOf(owner.getId());
        var reinforcements = Math.floor(playerTerritories.size() / 3) + this.map.getContinentBonus(owner.getId());
        for (int i = 0; i < reinforcements; i++) {
            reinforceMap.merge(playerTerritories.stream().findAny().get(), 1,Integer::sum);
        }
        return Optional.of(new ReinforceEvent(owner, reinforceMap));
    }
}
