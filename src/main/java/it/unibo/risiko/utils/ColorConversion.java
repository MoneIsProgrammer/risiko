package it.unibo.risiko.utils;

import java.util.List;
import java.util.Map;

import it.unibo.risiko.model.player.RisikoColors;
import javafx.scene.paint.Color;

public final class ColorConversion {
    final static private Map<Color, RisikoColors> map = Map.of(
        Color.YELLOW, RisikoColors.YELLOW,
        Color.RED, RisikoColors.RED,
        Color.GREEN, RisikoColors.GREEN,
        Color.BLUE, RisikoColors.BLUE,
        Color.PINK, RisikoColors.PINK,
        Color.BLACK, RisikoColors.BLACK);

    private ColorConversion() {

    }

    public static List<Color> getAvabileJavaFXColors() {
        return List.copyOf(map.keySet());
    }

    public static RisikoColors toRisikoColor (Color color) throws IllegalArgumentException {
        if (!correctColor(color)) {
            throw new IllegalArgumentException("Color is not one of the permitted values");
        }
        return map.get(color);
    }

    public static Color toJavaFxColor(RisikoColors color) {
        return map.entrySet().stream().filter(a -> a.getValue().equals(color)).findFirst().get().getKey();
    }

    private static boolean correctColor(Color color) {
        return map.containsKey(color);
    }
}
