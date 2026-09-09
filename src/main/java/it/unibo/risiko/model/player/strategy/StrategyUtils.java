package it.unibo.risiko.model.player.strategy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.map.Territory;

public class StrategyUtils {
    public  static final Comparator<Territory> TERRITORY_COMPARATOR = (a,b) -> Integer.compare(a.getArmies(), b.getArmies());


    private StrategyUtils() {

    }

        public static  Set<Territory> getBorderTerritories(Set<Territory> playerTerritories, GameMap map) { // creates a set containing player owned territories that border enemies
        Set<Territory> borderTerritories = new HashSet<>();
        for (Territory territory : playerTerritories) {
            for (String adj  : territory.getAdjacentIds()) {
                if (!playerTerritories.contains(map.getTerritory(adj))) {
                    borderTerritories.add(territory);
                    break;
                }
            }
        }
        return  borderTerritories;
    }
}
