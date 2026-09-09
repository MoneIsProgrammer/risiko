package it.unibo.risiko.model.player.strategy.ai;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;
import it.unibo.risiko.model.map.GameMap;
import it.unibo.risiko.model.player.Player;
import it.unibo.risiko.model.player.Roster;
import it.unibo.risiko.model.player.strategy.PlayerStrategy;

/**
 * Player strategy where the ai takes decisions randomly.
 */
public class RandomStrategy implements PlayerStrategy {


    public RandomStrategy(Roster roster, GameMap map) {
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
}
