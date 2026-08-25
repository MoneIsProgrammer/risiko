package it.unibo.risiko.model.player.strategy;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;

/**
 * General strategy implemetation giving the methods to get the result of an action.
 */
public interface PlayerStrategy {

    /**
     * Used to generate an attack event, if unable generates nothing
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    Optional<AttackEvent> getAttack(); //must pass gamestate so ai can use it, return optional to check 
    // if an event is passed or not either if move is invalid or the bot is done

    /**
     * Used to generate a move event, if unable generates nothing
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    Optional<MoveEvent> getMove();

    /**
     * Used to generate a reinforcement event, if unable generates nothing
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    Optional<ReinforceEvent> getReinforce();
}
