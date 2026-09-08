package it.unibo.risiko.model.player.strategy.ai;

import java.util.Optional;
import java.util.Set;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * PlayerStrategy where the ai attacks whoever it can if it has enough troops.
 */
public class AggressiveStrategy implements PlayerStrategy {

    @Override
    public Optional<AttackEvent> getAttack(Set<Territory> ownedTerritories) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttack'");
    }

    @Override
    public Optional<MoveEvent> getMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMove'");
    }

    @Override
    public Optional<ReinforceEvent> getReinforce() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReinforce'");
    }
}
