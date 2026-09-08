package it.unibo.risiko.model.battle;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Normal six faces dice.
 */
public final class RandomDice implements Dice {

    private static final int FACES = 6;

    private final Random random;

    /**
     * Creates the dice with a new {@link Random}.
     */
    public RandomDice() {
        this(new Random());
    }

    /**
     * Creates the dice with a {@link Random} passed from outside, with a fixed seed the same
     * sequence always comes out and it is easier to find a bug.
     *
     * @param random the source of random numbers to use
     */
    @SuppressFBWarnings(
            value = "EI_EXPOSE_REP2",
            justification = "the Random is shared on purpose, it is the only way to fix the seed from outside"
    )
    public RandomDice(final Random random) {
        this.random = random;
    }

    @Override
    public List<Integer> roll(final int amount) {
        if (amount < 1 || amount > MAX_DICE) {
            throw new IllegalArgumentException("You can roll from 1 to " + MAX_DICE + " dice");
        }
        final List<Integer> results = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            results.add(this.random.nextInt(FACES) + 1);
        }
        //sorted from the highest, so after this the comparison in pairs is direct
        results.sort(Collections.reverseOrder());
        return results;
    }
}
