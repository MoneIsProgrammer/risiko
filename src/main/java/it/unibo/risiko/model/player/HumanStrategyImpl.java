package it.unibo.risiko.model.player;

import java.util.Optional;

import it.unibo.risiko.model.common.Registry;
import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.map.Territory;
import it.unibo.risiko.model.player.strategy.HumanStrategy;

/**
 * HumanStrategyImpl
 */
public class HumanStrategyImpl implements HumanStrategy{


    public HumanStrategyImpl(Roster roster, GameMap map) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public Optional<AttackEvent> getAttack(Player owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAttack'");
    }

    @Override
    public Optional<MoveEvent> getMove(Player owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMove'");
    }

    @Override
    public Optional<ReinforceEvent> getReinforce(Player owner) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReinforce'");
    }

    @Override
    public void attackSource(Territory territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attackSource'");
    }

    @Override
    public void attackDestination(Territory territory) {
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
    public void moveSource(Territory territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveSource'");
    }

    @Override
    public void moveDestination(Territory territory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveDestination'");
    }

    @Override
    public void moveStrenght(int strength) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveStrenght'");
    }

}
