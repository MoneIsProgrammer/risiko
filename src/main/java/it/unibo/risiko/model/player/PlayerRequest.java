package it.unibo.risiko.model.player;

import java.util.Objects;

import javafx.scene.paint.Color;

/**
 * PlayerRequest
 * @param name name of the player
 * @param Ai type of ai player will use
 * @param color color of the player, unique is preferred
 */
public record PlayerRequest(String name, PlayerAI Ai, Color color) {
    /**
     * Type of ai this player will use
     */
    public final static class PlayerAI {
        public final static PlayerAI AGGRESSIVE = new PlayerAI("aggressive");
        public final static PlayerAI DEFENSIVE = new PlayerAI("defensive");
        public final static PlayerAI RANDOM = new PlayerAI("random");
        public final static PlayerAI HUMAN = new PlayerAI("human");
        private final String ai;
        
        private PlayerAI(String ai) {
            this.ai = ai;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof PlayerAI) {
                PlayerAI p = (PlayerAI)object;
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
