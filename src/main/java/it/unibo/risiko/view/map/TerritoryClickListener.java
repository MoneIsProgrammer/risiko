package it.unibo.risiko.view.map;

/**
 * Implemented by whoever wants to know where the user clicked on the {@link MapView}.
 * The map doesn't know the rules of the game, it only says which territory was pressed
 * and then the listener decides if the move is legal or not.
 */
@FunctionalInterface
public interface TerritoryClickListener {

    /**
     * called when the user clicks on a territory.
     *
     * @param territoryId id of the territory that was pressed
     */
    void onTerritoryClicked(String territoryId);

    /**
     * called when the user clicks on the map but outside of the territories, useful to
     * cancel a selection, whoever doesn't need it can ignore it.
     */
    default void onEmptyClicked() {
        //a click on nothing usually doesn't have to do anything
    }
}
