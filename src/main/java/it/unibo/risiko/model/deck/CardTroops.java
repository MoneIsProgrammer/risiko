package it.unibo.risiko.model.deck;

public enum CardTroops {
    CANNONS("Cannons"),
    INFANTRY("Infantry"),
    CAVALRY("Cavalry");

    private final String troopsName;

    // Constructor
    private CardTroops(String troopsName) {
        this.troopsName = troopsName;
    }

    // Getter
    public String getTroopName() {
        return troopsName;
    }
}
