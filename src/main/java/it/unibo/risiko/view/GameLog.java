package it.unibo.risiko.view;

import it.unibo.risiko.model.event.Event;
import it.unibo.risiko.model.event.EventVisitor;
import it.unibo.risiko.model.history.History;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameLog extends ScrollPane{
    
    private History history;
    private VBox content = new VBox();
    private EventStringVisitor visitor = new EventStringVisitor();

    public GameLog(History history) {
        super();
        this.setContent(this.content);
        this.history = history;
        this.history.addListener(new ListChangeListener<Event>() {

            @Override
            public void onChanged(Change<? extends Event> c) {
                while (c.next()) {
                    for (Event event : c.getAddedSubList()) {
                        var out = event.accept(visitor);
                        for (String string : out) {
                            content.getChildren().add(new Text(string));
                        }
                    }
                }
            }
        });
    }
}
