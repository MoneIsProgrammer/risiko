package it.unibo.risiko.model.player;

import java.util.Objects;

import it.unibo.risiko.model.player.PlayerRequest.PlayerStrategyRequest;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;
import it.unibo.risiko.model.player.strategy.ai.AggressiveStrategy;
import it.unibo.risiko.model.player.strategy.ai.DefensiveStrategy;
import it.unibo.risiko.model.player.strategy.ai.RandomStrategy;

public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Player generatePlayer(PlayerRequest playerRequest) throws NullPointerException {
        Objects.requireNonNull(playerRequest);
        return new PlayerImpl(playerRequest.color(), playerRequest.name(), createStrategy(playerRequest.ai()));
    }
    
    private PlayerStrategy createStrategy(PlayerStrategyRequest request) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(request);
        if(request.equals(PlayerStrategyRequest.AGGRESSIVE)) {
            return new AggressiveStrategy();
        }
        if(request.equals(PlayerStrategyRequest.DEFENSIVE)) {
            return new DefensiveStrategy();
        }
        if(request.equals(PlayerStrategyRequest.RANDOM)) {
            return new RandomStrategy();
        }
        if(request.equals(PlayerStrategyRequest.HUMAN)) {
            return new HumanStrategyImpl();
        }
        throw new IllegalArgumentException("The ai requested does not exists");
    }
}
