package it.unibo.risiko.model.map;

import it.unibo.risiko.model.common.Registry;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of {@link GameMap}.
 * The constructor is package private so the map can only be created by
 * {@link GameMapBuilder} and nobody can build a map that is half done.
 */
public final class GameMapImpl implements GameMap {

    private final Registry<Territory> territories;
    private final Registry<Continent> continents;

    /**
     * Creates the map with the two registries already filled by the builder.
     *
     * @param territories registry of the territories
     * @param continents registry of the continents
     */
    GameMapImpl(final Registry<Territory> territories, final Registry<Continent> continents) {
        this.territories = territories;
        this.continents = continents;
    }

    @Override
    public Collection<Territory> getTerritories() {
        return this.territories.values();
    }

    @Override
    public Territory getTerritory(final String id) {
        return this.territories.get(id);
    }

    @Override
    public Collection<Continent> getContinents() {
        return this.continents.values();
    }

    @Override
    public Continent getContinent(final String id) {
        return this.continents.get(id);
    }

    @Override
    public boolean areAdjacent(final String first, final String second) {
        return getTerritory(first).getAdjacentIds().contains(second);
    }

    @Override
    public Set<Territory> getTerritoriesOf(final String playerId) {
        return this.territories.stream()
                .filter(t -> isOwnedBy(t, playerId))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<String> getContinentOwner(final String continentId) {
        String owner = null;
        for (final String id : getContinent(continentId).getTerritoryIds()) {
            final Optional<String> current = getTerritory(id).getOwnerId();
            if (current.isEmpty()) {
                //one free territory is enough, the continent is of nobody
                return Optional.empty();
            }
            if (owner == null) {
                owner = current.get();
            } else if (!owner.equals(current.get())) {
                //two different owners, nobody has the whole continent
                return Optional.empty();
            }
        }
        return Optional.ofNullable(owner);
    }

    @Override
    public int getContinentBonus(final String playerId) {
        return this.continents.stream()
                .filter(c -> getContinentOwner(c.getId()).map(owner -> owner.equals(playerId)).orElse(false))
                .mapToInt(Continent::getBonusArmies)
                .sum();
    }

    @Override
    public boolean areConnected(final String fromId, final String toId, final String playerId) {
        final Territory from = getTerritory(fromId);
        final Territory to = getTerritory(toId);
        if (!isOwnedBy(from, playerId) || !isOwnedBy(to, playerId)) {
            return false;
        }
        if (fromId.equals(toId)) {
            return true;
        }
        //visit in width passing only on the territories of the player
        final Deque<String> toVisit = new ArrayDeque<>();
        final Set<String> visited = new HashSet<>();
        toVisit.add(fromId);
        visited.add(fromId);
        while (!toVisit.isEmpty()) {
            final Territory current = getTerritory(toVisit.poll());
            for (final String neighbour : current.getAdjacentIds()) {
                if (visited.contains(neighbour) || !isOwnedBy(getTerritory(neighbour), playerId)) {
                    continue;
                }
                if (neighbour.equals(toId)) {
                    return true;
                }
                visited.add(neighbour);
                toVisit.add(neighbour);
            }
        }
        return false;
    }

    private boolean isOwnedBy(final Territory territory, final String playerId) {
        return territory.getOwnerId().filter(owner -> owner.equals(playerId)).isPresent();
    }
}
