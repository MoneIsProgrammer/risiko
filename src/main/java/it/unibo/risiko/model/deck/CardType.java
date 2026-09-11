package it.unibo.risiko.model.deck;

public enum CardType {
    TERRITORY("Territory"),
    JOLLY("Jolly"),
    OBJECTIVE("Objective");

    private final String cardType;

    private CardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
