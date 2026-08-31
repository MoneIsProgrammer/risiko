package it.unibo.risiko.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PlayerSelectScene extends Scene {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private final FlowPane top;
    private final HBox bottom;
    private final GridPane mainBox;

    private final Button add;
    private final Button remove;
    private final TextField field;

    private int counter;

    public PlayerSelectScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        this.top = new FlowPane();
        this.bottom = new HBox();
        this.mainBox = (GridPane) this.getRoot();
        this.add = new Button("add");
        this.remove = new Button("remove");
        this.field = new TextField();
        this.counter = 0;
        initializeLayout();
        initializeButtons();
    }

    private void initializeLayout() {
        //mainBox.getChildren().addAll(top, bottom);
        mainBox.addRow(0, top);
        mainBox.addRow(1, bottom);
        mainBox.getRowConstraints();
        mainBox.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(add, remove, field);
        top.setBackground(
            new Background(
                new BackgroundFill(Color.RED, null, null)
            )
        );
        bottom.setBackground(
            new Background(
                new BackgroundFill(Color.BLUE, null, null)
            )
        );
        top.setMaxWidth(Double.MAX_VALUE);
        bottom.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(top, Priority.ALWAYS);
        VBox.setVgrow(bottom, Priority.ALWAYS);
        FlowPane.setMargin(top, new Insets(10));
        top.setOnMouseEntered(
            e -> top.setBackground(
                new Background(
                    new BackgroundFill(Color.GREEN, null, null)
                )
            )
        );
        top.setOnMouseExited(
            e -> top.setBackground(
                new Background(
                    new BackgroundFill(Color.LIME, null, null)
                )
            )
        );
    }
    
    private void initializeButtons() {
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addPlayer();
            }
        });
    }

    private void addPlayer() {
        counter++;
        if(counter >= 60) {
            return;
        }
        VBox box = new VBox();
        Label name = new Label(
            field.getText() + counter
        );
        box.getChildren().add(name);
        box.setPrefHeight(100);

        box.setBackground(
            new Background(
                new BackgroundFill(Color.ORANGE, null, null)
            )
        );
        FlowPane.setMargin(box, new Insets(10));
        box.setOnMouseClicked(
            e -> top.getChildren().remove(box)
        );
        top.getChildren().add(box);
    }
}
