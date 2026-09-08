package it.unibo.risiko.model.map;

import it.unibo.risiko.model.common.Registry;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Builds a {@link GameMap} one piece at a time.
 * A half built map can't be used, so territories and borders are added here and the map
 * object is created only at the end by {@link #build()}, when everything is checked.
 * Used like this:
 * <pre>
 * GameMap map = new GameMapBuilder()
 *         .addContinent("europe", "Europe", 5)
 *         .addTerritory("italy", "Italy", "europe")
 *         .addTerritory("france", "France", "europe")
 *         .addAdjacency("italy", "france")
 *         .build();
 * </pre>
 */
public final class GameMapBuilder {

    private final Map<String, TerritoryImpl> territories = new LinkedHashMap<>();
    private final Map<String, ContinentImpl> continents = new LinkedHashMap<>();
    private boolean built;

    /**
     * Adds a continent to the map that is being built.
     *
     * @param id unique id of the continent
     * @param name name to show on screen
     * @param bonus extra armies for who owns it completely, not negative
     * @return this builder, to concatenate the calls
     * @throws IllegalArgumentException if the continent is already there or the bonus is negative
     * @throws IllegalStateException if the map was already built
     */
    public GameMapBuilder addContinent(final String id, final String name, final int bonus) {
        checkNotBuilt();
        if (this.continents.containsKey(id)) {
            throw new IllegalArgumentException("Continent already present: " + id);
        }
        if (bonus < 0) {
            throw new IllegalArgumentException("The bonus of " + id + " can't be negative");
        }
        this.continents.put(id, new ContinentImpl(id, name, bonus));
        return this;
    }

    /**
     * Adds a territory and puts it inside its continent.
     *
     * @param id unique id of the territory
     * @param name name to show on screen
     * @param continentId the continent it belongs to, it has to be added first
     * @return this builder, to concatenate the calls
     * @throws IllegalArgumentException if the territory is already there or the continent is missing
     * @throws IllegalStateException if the map was already built
     */
    public GameMapBuilder addTerritory(final String id, final String name, final String continentId) {
        checkNotBuilt();
        if (this.territories.containsKey(id)) {
            throw new IllegalArgumentException("Territory already present: " + id);
        }
        final ContinentImpl continent = this.continents.get(continentId);
        if (continent == null) {
            throw new IllegalArgumentException("Continent does not exist: " + continentId);
        }
        this.territories.put(id, new TerritoryImpl(id, name, continentId));
        continent.addTerritory(id);
        return this;
    }

    /**
     * Adds a border in both directions, if A is on the border of B then B is on the border of A.
     *
     * @param first the first territory
     * @param second the second territory
     * @return this builder, to concatenate the calls
     * @throws IllegalArgumentException if one of the territories does not exist or if a
     *                                  territory is put on the border with itself
     * @throws IllegalStateException if the map was already built
     */
    public GameMapBuilder addAdjacency(final String first, final String second) {
        checkNotBuilt();
        if (first.equals(second)) {
            throw new IllegalArgumentException(first + " can't be on the border with itself");
        }
        final TerritoryImpl one = requireTerritory(first);
        final TerritoryImpl other = requireTerritory(second);
        one.addAdjacent(second);
        other.addAdjacent(first);
        return this;
    }

    /**
     * Checks that the map makes sense and returns it, after this call the builder is not usable.
     *
     * @return the complete map
     * @throws IllegalStateException if the map is empty, if a continent has no territories,
     *                               if a territory has no borders or if the builder was already used
     */
    public GameMap build() {
        checkNotBuilt();
        if (this.territories.isEmpty()) {
            throw new IllegalStateException("The map has no territories");
        }
        for (final ContinentImpl continent : this.continents.values()) {
            if (continent.getTerritoryIds().isEmpty()) {
                throw new IllegalStateException("The continent " + continent.getId() + " is empty");
            }
        }
        for (final TerritoryImpl territory : this.territories.values()) {
            if (territory.getAdjacentIds().isEmpty()) {
                throw new IllegalStateException(territory.getId() + " has no borders");
            }
        }

        final Registry<Territory> territoryRegistry = new Registry<>("Territory");
        this.territories.values().forEach(territoryRegistry::add);
        final Registry<Continent> continentRegistry = new Registry<>("Continent");
        this.continents.values().forEach(continentRegistry::add);

        this.built = true;
        return new GameMapImpl(territoryRegistry, continentRegistry);
    }

    private TerritoryImpl requireTerritory(final String id) {
        final TerritoryImpl territory = this.territories.get(id);
        if (territory == null) {
            throw new IllegalArgumentException("Territory does not exist: " + id);
        }
        return territory;
    }

    private void checkNotBuilt() {
        if (this.built) {
            throw new IllegalStateException("The map was already built");
        }
    }
}
