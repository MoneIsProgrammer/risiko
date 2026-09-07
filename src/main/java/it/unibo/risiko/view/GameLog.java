package it.unibo.risiko.view;

import it.unibo.risiko.model.event.Event;
import it.unibo.risiko.model.history.History;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class GameLog extends ScrollPane{
    
    private History history;
    private VBox content = new VBox();
    private EventStringVisitor visitor = new EventStringVisitor();

    public GameLog(History history) {
        super();
        this.setContent(this.content);
        this.content.setPadding(new Insets(5));
        this.history = history;
        this.content.heightProperty().addListener((a,b,c) -> setVvalue(1));
        this.setFitToWidth(true);
        this.history.addListener(new ListChangeListener<Event>() {

            @Override
            public void onChanged(Change<? extends Event> c) {
                while (c.next()) {
                    for (Event event : c.getAddedSubList()) {
                        var out = event.accept(visitor);
                        for (String string : out) {
                            Label label = new Label(string);
                            label.setWrapText(true);
                            label.setMaxWidth(Double.MAX_VALUE);
                            label.setPadding(new Insets(5));
                            Separator separator = new Separator();
                            content.getChildren().addAll(label, separator);
                        }
                    }
                }
            }
        });
    }
}
