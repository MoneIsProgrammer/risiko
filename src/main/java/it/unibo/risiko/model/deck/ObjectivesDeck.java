package it.unibo.risiko.model.deck;

public class ObjectivesDeck {
    /* We already have a constructor from the Hand class,
    so there's no need to add a constructor here */
    /* In order to populate our deck, we don't need any values, 
    so this is a void method */
    public void populate() {
        /* To populate, we're going to loop through all of our 
        territories and for each territory we'll add one of each troop */
        for (CardObjectives objectiveDescription: CardObjectives.values()) {
                Card card = new Card(objectiveDescription);
                /* Here "this" refers to each individual deck we create */
                this.add(card);
        }
    }
}
