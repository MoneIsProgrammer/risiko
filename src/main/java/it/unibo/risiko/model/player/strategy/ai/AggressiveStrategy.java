package it.unibo.risiko.model.player.strategy.ai;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.Player;
import it.unibo.risiko.model.player.Roster;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * PlayerStrategy where the ai attacks whoever it can if it has enough troops.
 */
public class AggressiveStrategy implements PlayerStrategy {

    private final Roster roster;
    private final GameMap map;

    public AggressiveStrategy(Roster roster, GameMap map) {
        this.roster = roster;
        this.map = map;
    }

    @Override
    public Optional<AttackEvent> getAttack(Player owner) { // if it can attack it will
        var playerTerritories = map.getTerritoriesOf(owner.getId());
        var borders = getBorderTerritories(playerTerritories);
        var source = borders.stream().filter(a -> a.getArmies() > 1).max((a, b) -> Integer.compare(a.getArmies(), b.getArmies()));
        if (source.isEmpty()) {
            return Optional.empty();
        }
        var destination = source.get().getAdjacentIds().stream() // ok because souce is a border
            .map(a -> map.getTerritory(a))
            .filter(a -> !playerTerritories.contains(a))
            .min((a,b) -> Integer.compare(a.getArmies(), b.getArmies()));
        if (destination.isEmpty()) {
            return  Optional.empty();
        }
        return Optional.of(new AttackEvent(owner, 
            this.roster.getPlayer(destination.get().getOwnerId().get()), 
            attackerStrenght(source.get()), 
            defenderStrenght(destination.get()), 
            source.get(), 
            destination.get()));
    }

    @Override
    public Optional<MoveEvent> getMove(Player owner) { // take the territory that isnt on the border with the most troops and moves all - 1 to the border with fewer troops.
        var playerTerritories = map.getTerritoriesOf(owner.getId());
        var borders = getBorderTerritories(playerTerritories);
        var source = playerTerritories.stream()
            .filter(a -> a.getArmies() > 2) 
            .filter(a -> !borders.contains(a))
            .max((a,b) -> Integer.compare(a.getArmies(), b.getArmies()));
        var destination = borders.stream().min((a,b) -> Integer.compare(a.getArmies(), b.getArmies()));
        if (source.isEmpty() || destination.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new MoveEvent(owner,
        source.get(),
        destination.get(),
        source.get().getArmies() - 1));
    }

    @Override
    public Optional<ReinforceEvent> getReinforce(Player owner) { // TODO add card bonuses when ready
        Map<Territory,Integer> reinforceMap = new HashMap<>();
        var playerTerritories = map.getTerritoriesOf(owner.getId());
        var reinforcements = Math.floor(playerTerritories.size() / 3); // arrotondamento per difetto
        reinforcements += map.getContinentBonus(owner.getId());
        var borders = getBorderTerritories(playerTerritories);
        for (int i = 0; i < reinforcements; i++) {
            var min = playerTerritories.stream().filter(a -> a.getArmies() < 2).findAny();
            if (min.isEmpty()) {
                min = borders.stream().min((a,b) -> Integer.compare(a.getArmies(), b.getArmies()));
            }
            reinforceMap.merge(min.get(), 1,Integer::sum); // sets the number of time a territory is to be reinforced with 1 troop
        }
        return Optional.of(new ReinforceEvent(owner, reinforceMap));

    }

    private Set<Territory> getBorderTerritories(Set<Territory> playerTerritories) { // creates a set containing player owned territories that border enemies
        Set<Territory> borderTerritories = new HashSet<>();
        for (Territory territory : playerTerritories) {
            for (String adj  : territory.getAdjacentIds()) {
                if (!playerTerritories.contains(this.map.getTerritory(adj))) {
                    borderTerritories.add(territory);
                    break;
                }
            }
        }
        return  borderTerritories;
    }

    private int attackerStrenght(Territory territory) {
        var str = territory.getArmies();
        if (str > 3) {
            return 3;
        } else {
            return str - 1;
        }
    }

    private int defenderStrenght(Territory territory) {
        var str = territory.getArmies();
        if (str > 3) {
            return 3;
        }
        else {
            return str;
        }
    }
}
