package it.unibo.risiko.model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Enum containing the colors avabile to the players
 */
public enum RisikoColors {
    YELLOW,
    RED,
    GREEN,
    BLUE,
    PINK,
    BLACK;

    /**
     * Used to get the colors in a different ordered list
     * @return a list of RisikoColor values
     */
    public static List<RisikoColors> shuffledValues() {
        List<RisikoColors> out = new ArrayList<>(List.of(values()));
        Collections.shuffle(out);
        return out;
    }
}
