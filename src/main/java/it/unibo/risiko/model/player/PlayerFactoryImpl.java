package it.unibo.risiko.model.player;

import java.util.Objects;

import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.player.PlayerRequest.PlayerStrategyRequest;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;
import it.unibo.risiko.model.player.strategy.ai.AggressiveStrategy;
import it.unibo.risiko.model.player.strategy.ai.DefensiveStrategy;
import it.unibo.risiko.model.player.strategy.ai.RandomStrategy;

public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Player generatePlayer(PlayerRequest playerRequest, Roster roster, GameMap map) throws NullPointerException {
        Objects.requireNonNull(playerRequest);
        return new PlayerImpl(playerRequest.color(), playerRequest.name(), createStrategy(playerRequest.ai(), roster, map));
    }
    
    private PlayerStrategy createStrategy(PlayerStrategyRequest request, Roster roster, GameMap map) {
        Objects.requireNonNull(request);
        if(request.equals(PlayerStrategyRequest.AGGRESSIVE)) {
            return new AggressiveStrategy(roster, map);
        }
        if(request.equals(PlayerStrategyRequest.DEFENSIVE)) {
            return new DefensiveStrategy(roster, map);
        }
        if(request.equals(PlayerStrategyRequest.RANDOM)) {
            return new RandomStrategy(roster, map);
        }
        if(request.equals(PlayerStrategyRequest.HUMAN)) {
            return new HumanStrategyImpl(roster, map);
        }
        throw new IllegalArgumentException("The ai requested does not exists");
    }
}
