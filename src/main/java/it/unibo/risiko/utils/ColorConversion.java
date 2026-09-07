package it.unibo.risiko.utils;

import java.util.List;
import java.util.Map;

import it.unibo.risiko.model.player.RisikoColors;
import javafx.scene.paint.Color;

/**
 * ColorConversion static class with utilities to manage player colors between model and view.
 */
public final class ColorConversion {
    private static final Map<Color, RisikoColors> MAP = Map.of(
        Color.YELLOW, RisikoColors.YELLOW,
        Color.RED, RisikoColors.RED,
        Color.GREEN, RisikoColors.GREEN,
        Color.BLUE, RisikoColors.BLUE,
        Color.PINK, RisikoColors.PINK,
        Color.BLACK, RisikoColors.BLACK);

    private ColorConversion() {

    }

    /**
     * Used do get the javaFX equivalent for all player colors.
     * 
     * @return a set of the colors avabile
     */
    public static List<Color> getAvabileJavaFXColors() {
        return List.copyOf(MAP.keySet());
    }

    /**
     * Converts JavaFX Color to the model equivalent.
     * 
     * @param color JavaFX color to be converted
     * 
     * @return the correspondent color for the model
     */
    public static RisikoColors toRisikoColor(final Color color) {
        if (!correctColor(color)) {
            throw new IllegalArgumentException("Color is not one of the permitted values");
        }
        return MAP.get(color);
    }

    /**
     * Converts model's color to a javaFX equivalent.
     * 
     * @param color the color the model utilizes to be converted
     * 
     * @return the corresponted JavaFX Color for the view
     */
    public static Color toJavaFxColor(final RisikoColors color) {
        return MAP.entrySet().stream().filter(a -> a.getValue() == color).findFirst().get().getKey();
    }

    private static boolean correctColor(final Color color) {
        return MAP.containsKey(color);
    }
}
