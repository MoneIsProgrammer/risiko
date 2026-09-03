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
public record PlayerRequest(String name, PlayerStrategy ai, RisikoColors color) {
    /**
     * Type of ai this player will use.
     */
    public static final class PlayerStrategy {
        /**
         * costant to be used to define the type of strategy the player will use
         */
        public static final PlayerStrategy AGGRESSIVE = new PlayerStrategy("aggressive");
        
        /**
         * costant to be used to define the type of strategy the player will use
         */
        public static final PlayerStrategy DEFENSIVE = new PlayerStrategy("defensive");
        
        /**
         * costant to be used to define the type of strategy the player will use
         */
        public static final PlayerStrategy RANDOM = new PlayerStrategy("random");
        
        /**
         * costant to be used to define the type of strategy the player will use
         */
        public static final PlayerStrategy HUMAN = new PlayerStrategy("human");
        private final String ai;

        private PlayerStrategy(final String ai) {
            this.ai = ai;
        }

        @Override
        public String toString() {
            return this.ai;
        }

        @Override
        public boolean equals(final Object object) {
            if (object instanceof PlayerStrategy) {
                final PlayerStrategy p = (PlayerStrategy) object;
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
