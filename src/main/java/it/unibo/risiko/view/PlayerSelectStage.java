package it.unibo.risiko.view;

import java.util.ArrayList;
import java.util.List;

import it.unibo.risiko.model.player.PlayerRequest;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerSelectStage extends Application{ //test class to lauch scenes

    @Override
    public void start(Stage stage) throws Exception {
        List<PlayerRequest> list = new ArrayList<>();
        stage.setTitle("MyShapes with JavaFX");
        stage.setScene(new MainMenuScene(e -> stage.setScene(makScene()), e -> System.out.print("load"), false));
        stage.show();
    }

    public Scene makScene() {
        return new PlayerSelectScene(e -> System.out.print(e.toString()));
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
 