package it.unibo.risiko.model.player;

import java.util.Objects;

import javafx.scene.paint.Color;

/**
 * Used as DTO between view and model to generate players.
 * 
 * @param name name of the player
 * @param ai type of ai player will use
 * @param color color of the player, unique is preferred
 */
public record PlayerRequest(String name, PlayerAI ai, Color color) {
    /**
     * Type of ai this player will use.
     */
    public static final class PlayerAI {
        public static final PlayerAI AGGRESSIVE = new PlayerAI("aggressive");
        public static final PlayerAI DEFENSIVE = new PlayerAI("defensive");
        public static final PlayerAI RANDOM = new PlayerAI("random");
        public static final PlayerAI HUMAN = new PlayerAI("human");
        private final String ai;

        private PlayerAI(final String ai) {
            this.ai = ai;
        }

        @Override
        public String toString() {
            return this.ai;
        }

        @Override
        public boolean equals(final Object object) {
            if (object instanceof PlayerAI) {
                final PlayerAI p = (PlayerAI) object;
                return this.ai.equals(p.ai);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.ai);
        }
    }
}
