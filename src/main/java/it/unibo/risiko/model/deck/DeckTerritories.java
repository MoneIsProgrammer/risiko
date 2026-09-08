package it.unibo.risiko.model.deck;

/**
 * Enum class is being used, as the values of each 
 * territory in the deck are fixed
 */
public enum DeckTerritories {
    AFGHANISTAN("Afghanistan", 4),
    NORTHAFRICA("North Africa", 6),
    SOUTHAFRICA("South Africa", 3),
    EASTAFRICA("East Africa", 5),
    ALASKA("Alaska", 3),
    ALBERTA("Alberta", 4),
    CENTRALAMERICA("Central America", 3),
    ARGENTINA("Argentina", 2),
    WESTERNAUSTRALIA("Western Australia", 3),
    EASTERNAUSTRALIA("Eastern Australia", 2),
    BRAZIL("Brazil", 4),
    CHINA("China", 7),
    CHILE("Chile", 4),
    CONGO("Congo", 3),
    EGYPT("Egypt", 4),
    SOUTHERNEUROPE("Southern Europe", 6),
    WESTERNEUROPE("Western Europe", 4),
    NORTHERNEUROPE("Northern Europe", 5),
    JAPAN("Japan", 2),
    GREATBRITAIN("Great Britain", 4),
    GREENLAND("Greenland", 4),
    INDIA("India", 3),
    INDONESIA("Indonesia", 3),
    ICELAND("Iceland", 3),
    YAKUTIA("Yakutia", 3),
    KAMCHATKA("Kamchatka", 5),
    MADAGASCAR("Madagascar", 2),
    MIDDLEEAST("Middle East", 6),
    MONGOLIA("Mongolia", 5),
    NEWGUINEA("New Guinea", 3),
    ONTARIO("Ontario", 6),
    PERU("Peru", 3),
    QUEBEC("Quebec", 3),
    SCANDINAVIA("Scandinavia", 4),
    SIAM("Siam", 3),
    SIBERIA("Siberia", 5),
    WESTERNAMERICA("Western America", 4),
    EASTERNAMERICA("Eastern America", 4),
    NORTHWESTTERRITORIES("Northwest Territories", 4),
    UKRAINE("Ukraine", 6),
    URALS("Urals", 4),
    VENEZUELA("Venezuela", 3);

    /**
     * The private fields are final, to ensure
     * that they are not modified during runtime
     */
    private final String territoryName;
    private final int territoryValue;

    // Constructor
    private DeckTerritories(String territoryName, int territoryValue) {
        this.territoryName = territoryName;
        this.territoryValue = territoryValue;
    }

    // Public Method - Getters
    public String getTerritoryName() {
        return territoryName;
    }

    public int getTerritoryValue() {
        return territoryValue;
    }
}