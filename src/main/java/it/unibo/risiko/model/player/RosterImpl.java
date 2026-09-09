package it.unibo.risiko.model.player;

import java.util.List;
import java.util.Optional;

import it.unibo.risiko.model.common.Registry;
import it.unibo.risiko.model.map.GameMap;

public class RosterImpl implements Roster {
    private final Registry<Player> roster;
    
    public RosterImpl(List<PlayerRequest> players, GameMap map){
        this.roster = new Registry<Player>("players");
        PlayerFactory factory = new PlayerFactoryImpl();
        for (PlayerRequest request : players) {
            this.roster.add(factory.generatePlayer(request, this, map));
        }
    }

    /** (non-Javadoc)
     * @see it.unibo.risiko.model.player.Roster#getPlayer(java.lang.String)
     */
    @Override
    public Player getPlayer(String playerId) {
        return this.roster.get(playerId);
    }

    /** (non-Javadoc)
     * @see it.unibo.risiko.model.player.Roster#getPlayer(it.unibo.risiko.model.player.RisikoColors)
     */
    @Override
    public Optional<Player> getPlayer(RisikoColors color) {
        return  this.roster.values().stream().filter(a -> a.getColor() == color).findFirst();
    }

    /** (non-Javadoc)
     * @see it.unibo.risiko.model.player.Roster#getAllPlayers()
     */
    @Override
    public List<Player> getAllPlayers() {
        return List.copyOf(this.roster.values());
    }
}
