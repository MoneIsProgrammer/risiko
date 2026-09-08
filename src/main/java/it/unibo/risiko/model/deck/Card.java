package it.unibo.risiko.model.deck;

/* I have removed territoryValue from the card for now */
public class Card {

    // Private Fields, each card has a territory and a troop
    private DeckTerritories territoryName;
    private DeckTerritories territoryValue;
    private DeckTroops troop;
    private boolean isFaceUp;

    // Constructor
    public Card(DeckTerritories territoryName, DeckTroops troop) {
        this.territoryName = territoryName;
        //this.territoryValue = territoryValue;
        this.troop = troop;
        isFaceUp = true;
    }

    // Getters
    public String getTerritoryName() {
        return territoryName.getTerritoryName();
    }
/*
    public int getTerritoryValue() {
        return  territoryValue.getTerritoryValue();
    }
*/
    public String getTroop() {
        return troop.getTroopName();
    }

    public String cardValue() {
        String str = "";
        if (isFaceUp) {
            str += territoryName.getTerritoryName() + " value: " + territoryValue.getTerritoryValue() + ", troop: " + troop.getTroopName();
        } else {
            str = "Face Down (nothing to see here)";
        }
        return str;
    }
}
