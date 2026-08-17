package it.unibo.risiko.model.player.strategy;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;

public interface PlayerStrategy {


    public Optional<AttackEvent> getAttack(); //must pass gamestate so ai can use it, return optional to check if an event is passed or not either if move is invalid or the bot is done

    public Optional<MoveEvent> getMove();

    public Optional<ReinforceEvent> getReinforce();
}
