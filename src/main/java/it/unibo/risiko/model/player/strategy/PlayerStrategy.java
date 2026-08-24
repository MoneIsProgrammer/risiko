package it.unibo.risiko.model.player.strategy;

import java.util.Optional;

import it.unibo.risiko.model.event.AttackEvent;
import it.unibo.risiko.model.event.MoveEvent;
import it.unibo.risiko.model.event.ReinforceEvent;

/**
 * General strategy implemetation giving the methods to get the result of an action
 */
public interface PlayerStrategy {


    /**
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    public Optional<AttackEvent> getAttack(); //must pass gamestate so ai can use it, return optional to check 
    // if an event is passed or not either if move is invalid or the bot is done

    /**
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    public Optional<MoveEvent> getMove();

    /**
     * @return an {@link Optional} containing the event, if event can't be generated returns {@link Optional#empty()}
     */
    public Optional<ReinforceEvent> getReinforce();
}
