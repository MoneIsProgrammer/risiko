package it.unibo.risiko.model.deck;

public enum DeckTroops {
    CANNONS("Cannons"),
    INFANTRY("Infantry"),
    CAVALRY("Cavalry"),
    JOLLY("Jolly");

    private final String troopsName;

    // Constructor
    private DeckTroops(String troopsName) {
        this.troopsName = troopsName;
    }

    // Getter
    public String getTroopName() {
        return troopsName;
    }
}
