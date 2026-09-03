package it.unibo.risiko.model.player;

import java.util.Objects;

import it.unibo.risiko.model.player.PlayerRequest.PlayerStrategyRequest;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;
import it.unibo.risiko.model.player.strategy.ai.AggressiveStrategyImpl;
import it.unibo.risiko.model.player.strategy.ai.DefensiveStrategyImpl;
import it.unibo.risiko.model.player.strategy.ai.RandomStrategyImpl;

public class PlayerFactoryImpl implements PlayerFactory {

    @Override
    public Player generatePlayer(PlayerRequest playerRequest) throws NullPointerException {
        Objects.requireNonNull(playerRequest);
        return new PlayerImpl(playerRequest.color(), playerRequest.name(), createStrategy(playerRequest.ai()));
    }
    
    private PlayerStrategy createStrategy(PlayerStrategyRequest request) {
        Objects.requireNonNull(request);
        if(request.equals(PlayerStrategyRequest.AGGRESSIVE)) {
            return new AggressiveStrategyImpl();
        }
        if(request.equals(PlayerStrategyRequest.DEFENSIVE)) {
            return new DefensiveStrategyImpl();
        }
        if(request.equals(PlayerStrategyRequest.RANDOM)) {
            return new RandomStrategyImpl();
        }
        if(request.equals(PlayerStrategyRequest.HUMAN)) {
            return new HumanStrategyImpl();
        }
        throw new IllegalArgumentException("The ai requested does not exists");
    }
}
