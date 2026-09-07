package it.unibo.risiko.model.player.strategy.ai;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * PlayerStrategy where the ai prefers to bolster its defenses rather than attack recklessly.
 */
public class DefensiveStrategy implements PlayerStrategy {

    @Override
    public Optional<AttackEvent> getAttack() {
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
