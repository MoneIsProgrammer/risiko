package it.unibo.risiko.model.deck;

/* I have removed territoryValue from the card for now */
public class Card {

    // Private Fields, each card has a territory and a troop
    private CardTerritories territoryName;
    private CardTroops troop;
    private CardObjectives objectiveDescription;
    private CardType cardType;

    // Constructor for territory cards
    public Card(CardTerritories territoryName, CardTroops troop) {
        this.territoryName = territoryName;
        this.troop = troop;
        this.cardType = CardType.TERRITORY;
    }

    // Constructor for jolly cards
    public Card() {
        this.cardType = CardType.JOLLY;
    }

    // Constructor for objective cards
    public Card(CardObjectives objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.cardType = CardType.OBJECTIVE;
    }

    // Getters
    public String getTerritoryName() {
        return territoryName.getTerritoryName();
    }

    public String getTroop() {
        return troop.getTroopName();
    }

    public String getObjectiveDescription() {
        return objectiveDescription.getObjective();
    }

    public String getCardType() {
        return cardType.getCardType();
    }
}
