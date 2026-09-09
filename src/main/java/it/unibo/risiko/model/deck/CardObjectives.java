package it.unibo.risiko.model.deck;

public enum CardObjectives {
    OBJECTIVE1("Conquer 18 territories, the territories must have atleast two troops each"),
    OBJECTIVE2("Conquer 24 territories"),
    OBJECTIVE3("Conquer all of North America and Africa"),
    OBJECTIVE4("Conquer all of North America and Oceania"),
    OBJECTIVE5("Conquer all of Asia and South America"),
    OBJECTIVE6("Conquer all of Asia and Africa"),
    OBJECTIVE7("Conquer all of Europe, South America and a third continent of your choice"),
    OBJECTIVE8("Conquer all of Europe, Oceania and a third continent of your choice"),
    OBJECTIVE9("");

    private final String objectiveDescription;

    // Constructor
    private CardObjectives (String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    // Getter
    public String getObjective () {
        return objectiveDescription;
    }
}
