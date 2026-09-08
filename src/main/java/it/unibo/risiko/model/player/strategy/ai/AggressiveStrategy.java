package it.unibo.risiko.model.player.strategy.ai;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * PlayerStrategy where the ai attacks whoever it can if it has enough troops.
 */
public class AggressiveStrategy implements PlayerStrategy {

    @Override
    public Optional<AttackEvent> getAttack(GameMap map, String owner) {
        var playerTerritories = map.getTerritoriesOf(owner);
        var borders = getBorderTerritories(map, playerTerritories);
        var source = borders.stream().filter(a -> a.getArmies() > 1).max((a, b) -> Integer.compare(a.getArmies(), b.getArmies()));
        if (source.isEmpty()) {
            return Optional.empty();
        }
        var destination = source.get().getAdjacentIds().stream().map(a -> map.getTerritory(a)).filter(a -> !playerTerritories.contains(a)).min((a,b) -> Integer.compare(a.getArmies(), b.getArmies()));
        if (destination.isEmpty()) {
            return  Optional.empty();
        }
        return Optional.of(new AttackEvent(owner, 
            destination.get().getOwnerId().get(), 
            attackerStrenght(source.get()), 
            defenderStrenght(destination.get()), 
            source.get().getName(), 
            destination.get().getName()));
    }

    @Override
    public Optional<MoveEvent> getMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMove'");
    }

    @Override
    public Optional<ReinforceEvent> getReinforce() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReinforce'");
    }

    private Set<Territory> getBorderTerritories(GameMap map, Set<Territory> playerTerritories) {
        Set<Territory> borderTerritories = new HashSet<>();
        for (Territory territory : playerTerritories) {
            for (String adj  : territory.getAdjacentIds()) {
                if (playerTerritories.contains(map.getTerritory(adj))) {
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
