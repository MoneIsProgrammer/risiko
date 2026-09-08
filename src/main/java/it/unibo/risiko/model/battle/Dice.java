package it.unibo.risiko.model.battle;

import java.util.List;

/**
 * The roll of the dice.
 * It is an interface because the tests need a version with the results decided before,
 * otherwise there is no way to check the result of a battle. The ai can use its own dice
 * too when it simulates an attack.
 */
@FunctionalInterface
public interface Dice {

    /** Maximum number of dice that can be rolled at the same time. */
    int MAX_DICE = 3;

    /**
     * Rolls the dice.
     *
     * @param amount how many dice to roll, from 1 to {@link #MAX_DICE}
     * @return the values that came out, from the highest to the lowest
     * @throws IllegalArgumentException if amount is not between 1 and {@link #MAX_DICE}
     */
    List<Integer> roll(int amount);
}
