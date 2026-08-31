package it.unibo.risiko.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerSelectStage extends Application{

    @Override
    public void start(Stage stage) throws Exception {// Create an Ellipse and set fill color
        stage.setTitle("MyShapes with JavaFX");
        stage.setScene(this.makScene(e -> stage.setScene(new PlayerSelectScene())));
        stage.show();
    }

    public Scene makScene(EventHandler<ActionEvent> change) {
        Button button = new Button("cambio");
        button.setOnAction(change);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(button);
        Scene scene = new Scene(stackPane, 350, 230, Color.LIGHTYELLOW);
        return scene;
    }

    public static final class Main {
        private Main() {
            // the constructor will never be called directly.
        }

        /**
         * Program's entry point.
         *
         * @param args ignored
         */
        public static void main(final String... args) {
            launch(PlayerSelectStage.class, args);
            /*
            The following line raises: Error: class it.unibo.samplejavafx.JavaFXApp$Main
            is not a subclass of javafx.application.Application
            Because if you do not provide the Application subclass to launch() it will consider the enclosing class)
            */
            // JavaFXApp.launch(args);
            // Whereas the following would do just fine:
            // JavaFXApp.run(args)
        }
    }
    
}
 