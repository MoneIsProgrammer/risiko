package it.unibo.risiko.model.player;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.player.strategy.HumanStrategy;

/**
 * HumanStrategyImpl
 */
public class HumanStrategyImpl implements HumanStrategy{

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

    @Override
    public void attackSource(String territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackSource'");
    }

    @Override
    public void attackDestination(String territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackDestination'");
    }

    @Override
    public void attackStrenght(int strength) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackStrenght'");
    }

    @Override
    public void reinforce(int strength) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reinforce'");
    }

    @Override
    public void moveSource(String territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveSource'");
    }

    @Override
    public void moveDestination(String territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveDestination'");
    }

    @Override
    public void moveStrenght(int strength) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveStrenght'");
    }

}
