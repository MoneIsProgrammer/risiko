package it.unibo.risiko.view.map;

import it.unibo.risiko.model.event.GameObserver;
import it.unibo.risiko.model.player.RisikoColors;
import java.util.Optional;
import java.util.Set;

/**
 * The map as it is seen from outside the view, so that the controller never names a JavaFX
 * class and changing the graphics library only means writing another implementation.
 * For the same reason the colors are the ones of the model and the territories travel as ids.
 * It extends {@link GameObserver} because the map redraws itself when something happens.
 */
public interface MapView extends GameObserver {

    /**
     * sets the color used to draw the territories of a player.
     *
     * @param playerId id of the player
     * @param color color of that player
     */
    void setPlayerColor(String playerId, RisikoColors color);

    /**
     * selects a territory, the one selected before is deselected.
     *
     * @param territoryId id of the territory to select
     * @throws IllegalArgumentException if that territory is not on the map
     */
    void setSelected(String territoryId);

    /**
     * Returns the territory that is selected right now.
     *
     * @return an {@link Optional} containing its id, {@link Optional#empty()} if nothing is selected
     */
    Optional<String> getSelected();

    /**
     * removes the selection, if there is one. It is a method of its own because
     * {@link #setSelected(String)} only accepts territories that exist on the map.
     */
    void clearSelection();

    /**
     * marks a group of territories, for example the ones that can be attacked from the
     * selected one, an empty set clears the previous marking.
     *
     * @param territoryIds ids of the territories to mark
     */
    void setHighlighted(Set<String> territoryIds);

    /**
     * registers a listener that will be told about the clicks on the map.
     *
     * @param listener the listener to add
     */
    void addTerritoryClickListener(TerritoryClickListener listener);

    /**
     * draws the map again, the view calls it by itself on an event or on a resize so from
     * outside it is only needed after changing the colors.
     */
    void redraw();
}
