package it.unibo.risiko.model.battle;

import it.unibo.risiko.model.map.Territory;

/**
 * Solves a battle between two territories that are on the border.
 */
public interface CombatSystem {

    /**
     * Rolls the dice and calculates the losses. It does not touch the territories, it only
     * returns the result, the one who manages the turn is the one that applies it.
     *
     * @param attacker territory that attacks
     * @param defender territory that defends
     * @param attackingArmies armies that attack, from 1 to {@link Dice#MAX_DICE}, at least
     *                        one army has to stay in the territory
     * @param defendingArmies armies that defend, from 1 to {@link Dice#MAX_DICE}, not more
     *                        than the ones in the territory
     * @return the result of the battle
     * @throws IllegalArgumentException if the numbers of armies are not correct or if the
     *                                  two territories are not on the border
     */
    BattleResult resolve(Territory attacker, Territory defender, int attackingArmies, int defendingArmies);

    /**
     * How many dice at most can be rolled attacking from this territory.
     *
     * @param attacker the territory the attack starts from
     * @return the maximum number of dice, 0 if from there you can not attack
     */
    int maxAttackDice(Territory attacker);

    /**
     * How many dice at most can be rolled defending this territory.
     *
     * @param defender the territory that defends
     * @return the maximum number of dice
     */
    int maxDefenceDice(Territory defender);
}
