package it.unibo.risiko.model.deck;

/* I have removed territoryValue from the card for now */
public class Card {

    // Private Fields, each card has a territory and a troop
    private CardTerritories territoryName;
    private CardTroops troop;
    private CardObjectives objectiveDescription;
    private String cardType;

    // Constructor
    public Card(CardTerritories territoryName, CardTroops troop) {
        this.territoryName = territoryName;
        this.troop = troop;
        this.cardType = "Territory";
    }

    public Card() {
        this.cardType = "Jolly";
    }

    public Card(CardObjectives objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.cardType = "Objective";
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
        return cardType;
    }
}
