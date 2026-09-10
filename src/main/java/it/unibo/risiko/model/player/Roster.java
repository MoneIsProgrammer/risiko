package it.unibo.risiko.model.player;

import java.util.List;
import java.util.Optional;

public interface Roster {

    Player getPlayer(String playerId);

    Optional<Player> getPlayer(RisikoColors color);

    List<Player> getAllPlayers();

}