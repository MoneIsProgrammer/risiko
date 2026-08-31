package it.unibo.risiko.view;

import it.unibo.samplejavafx.JavaFXApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayerSelectStage extends Application{

    @Override
    public void start(Stage stage) throws Exception {// Create an Ellipse and set fill color
        stage.setTitle("MyShapes with JavaFX");
        stage.setScene(this.makScene(e -> stage.setScene(this.culo())));
        stage.show();
    }

    public Scene makScene(EventHandler<ActionEvent> change) {
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);
        // Create a Text shape with font and size
        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));
        Button button = new Button("cambio");
        button.setOnAction(change);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text,button);
        Scene scene = new Scene(stackPane, 350, 230, Color.LIGHTYELLOW);
        return scene;
    }

    public Scene culo() {
        HBox top = new HBox();
        HBox bottom = new HBox();
        VBox vBox = new VBox(top,bottom);
        vBox.setAlignment(Pos.CENTER);
        Label label = new Label("top");
        label.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        Label label2 = new Label("bot");
        top.getChildren().add(label2);
        top.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        top.setOnMouseEntered(e -> top.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null))));
        top.setOnMouseExited(e -> top.setBackground(new Background(new BackgroundFill(Color.LIME,null,null))));
        bottom.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        bottom.getChildren().add(label);
        top.setMaxWidth(Double.MAX_VALUE);
        bottom.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(top, Priority.ALWAYS);
        VBox.setVgrow(bottom, Priority.ALWAYS);

        return new Scene(vBox,600, 600);
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
 