package it.unibo.risiko.model.map;

import it.unibo.risiko.model.common.Identifiable;
import java.util.Set;

/**
 * A continent, a group of territories that gives extra armies to who owns all of them.
 * Who owns it is not saved here, it is calculated from the territories by
 * {@link GameMap#getContinentOwner(String)}.
 */
public interface Continent extends Identifiable {

    /**
     * Name to show on screen.
     *
     * @return the name of the continent
     */
    String getName();

    /**
     * The territories that are part of the continent.
     *
     * @return their ids in an unmodifiable set
     */
    Set<String> getTerritoryIds();

    /**
     * Extra armies that who owns the whole continent gets every turn.
     *
     * @return the bonus in armies
     */
    int getBonusArmies();
}
