package it.unibo.risiko.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PlayerSelectScene extends Scene {

    public PlayerSelectScene() {
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
        super(vBox, 500, 500);
    }
    
}
