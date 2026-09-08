package it.unibo.risiko.model.map;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * The game map: territories, continents and borders.
 * This is the only thing the other packages use to know the geography of the game.
 */
public interface GameMap {

    /**
     * All the territories in loading order.
     *
     * @return the territories in an unmodifiable collection
     */
    Collection<Territory> getTerritories();

    /**
     * Searches a territory by id.
     *
     * @param id the id of the territory
     * @return the territory with that id
     * @throws IllegalArgumentException if the id does not exist
     */
    Territory getTerritory(String id);

    /**
     * All the continents in loading order.
     *
     * @return the continents in an unmodifiable collection
     */
    Collection<Continent> getContinents();

    /**
     * Searches a continent by id.
     *
     * @param id the id of the continent
     * @return the continent with that id
     * @throws IllegalArgumentException if the id does not exist
     */
    Continent getContinent(String id);

    /**
     * Tells if two territories are on the border.
     *
     * @param first the first territory
     * @param second the second territory
     * @return true if they are neighbours
     * @throws IllegalArgumentException if the first id does not exist
     */
    boolean areAdjacent(String first, String second);

    /**
     * All the territories of a player.
     *
     * @param playerId the id of the player
     * @return his territories, an empty set if he has none
     */
    Set<Territory> getTerritoriesOf(String playerId);

    /**
     * Who owns a whole continent.
     *
     * @param continentId the id of the continent
     * @return the id of the owner, empty if the continent is not all of one player
     * @throws IllegalArgumentException if the id of the continent does not exist
     */
    Optional<String> getContinentOwner(String continentId);

    /**
     * Sum of the bonuses of the continents the player owns completely.
     *
     * @param playerId the id of the player
     * @return the extra armies, 0 if he has no complete continent
     */
    int getContinentBonus(String playerId);

    /**
     * Tells if you can go from one territory to another passing only on territories of the
     * same player, it is needed to check the movement at the end of the turn.
     *
     * @param fromId starting territory
     * @param toId arriving territory
     * @param playerId the player that has to own the whole path
     * @return true if the path exists
     * @throws IllegalArgumentException if one of the two ids does not exist
     */
    boolean areConnected(String fromId, String toId, String playerId);
}
