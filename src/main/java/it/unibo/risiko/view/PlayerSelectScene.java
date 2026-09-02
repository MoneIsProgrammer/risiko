package it.unibo.risiko.view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import it.unibo.risiko.model.player.PlayerRequest;
import it.unibo.risiko.model.player.PlayerRequest.PlayerAI;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
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
    private static final int MAX_PLAYERS = 6;
    private static final int MIN_PLAYERS = 3;
    private static final Color BACKGROUN_COLOR = Color.GREY;


    private final FlowPane top;
    private final BorderPane bottom;
    private final GridPane mainBox;

    private final Button addHuman;
    private final Button addAggressive;
    private final Button addDefensive;
    private final Button addRandom;

    private final Button done;
    private final TextField field;

    private final List<PlayerRequest> players = new ArrayList<>();
    private final List<Color> playerColors = new ArrayList<>();

    private int counter = 0;
    private final Consumer<List<PlayerRequest>> onDone;

    public PlayerSelectScene(Consumer<List<PlayerRequest>> onDone) {
        super(new GridPane(), WIDTH, HEIGHT);
        this.onDone = onDone;
        this.top = new FlowPane();
        this.bottom = new BorderPane();
        this.mainBox = (GridPane) this.getRoot();
        this.addHuman = new Button("human");
        this.addAggressive = new Button("aggressive");
        this.addDefensive = new Button("defensive");
        this.addRandom = new Button("random");
        this.done = new Button("Inizia la partita");
        this.field = new TextField();
        this.playerColors.addAll(List.of(Color.YELLOW,Color.RED,Color.GREEN,Color.BLUE,Color.PINK,Color.BLACK));
        initializeLayout();
        initializeButtons();
    }

    private void initializeLayout() {
        var playerChoiceBox = new HBox(addHuman,addAggressive,addDefensive,addRandom);
        playerChoiceBox.setSpacing(25);
        top.setMaxWidth(Double.MAX_VALUE);
        top.setAlignment(Pos.TOP_CENTER);
        bottom.setMaxWidth(Double.MAX_VALUE);
        mainBox.addRow(0, top);
        mainBox.addRow(1, bottom);
        var topSize = new RowConstraints();
        topSize.setPercentHeight(70);
        var botSize = new RowConstraints();
        botSize.setPercentHeight(30);
        var columnSize = new ColumnConstraints();
        columnSize.setPercentWidth(100);
        mainBox.getColumnConstraints().add(columnSize);
        mainBox.getRowConstraints().addAll(topSize,botSize);
        mainBox.setAlignment(Pos.CENTER);
        bottom.setTop(done);
        bottom.setCenter(playerChoiceBox);
        bottom.setBottom(field);
        //bottom.setPadding(new Insets(10));
        playerChoiceBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(this.done, Pos.TOP_CENTER);
        BorderPane.setMargin(done, new Insets(0, 0, 20, 0));
        BorderPane.setMargin(playerChoiceBox, new Insets(0, 0, 20, 0));
        BorderPane.setMargin(this.field, new Insets(20));
        top.setBackground(
            new Background(
                new BackgroundFill(BACKGROUN_COLOR, null, null)
            )
        );
        bottom.setBackground(
            new Background(
                new BackgroundFill(BACKGROUN_COLOR, null, null)
            )
        );
        top.setMaxWidth(Double.MAX_VALUE);
        bottom.setMaxWidth(Double.MAX_VALUE);
        FlowPane.setMargin(top, new Insets(10));
        this.field.setPromptText("Nome del giocatore");
    }

    private void initializeButtons() {
        this.addHuman.setOnAction(e -> addPlayer(PlayerAI.HUMAN));
        this.addHuman.prefWidthProperty().bind(bottom.widthProperty().multiply(0.2));
        this.addHuman.prefHeightProperty().bind(bottom.heightProperty().multiply(0.4));

        this.addAggressive.setOnAction(e -> addPlayer(PlayerAI.AGGRESSIVE));
        this.addAggressive.prefWidthProperty().bind(bottom.widthProperty().multiply(0.2));
        this.addAggressive.prefHeightProperty().bind(bottom.heightProperty().multiply(0.4));

        this.addRandom.setOnAction(e -> addPlayer(PlayerAI.RANDOM));
        this.addRandom.prefWidthProperty().bind(bottom.widthProperty().multiply(0.2));
        this.addRandom.prefHeightProperty().bind(bottom.heightProperty().multiply(0.4));

        this.addDefensive.setOnAction(e -> addPlayer(PlayerAI.DEFENSIVE));
        this.addDefensive.prefWidthProperty().bind(bottom.widthProperty().multiply(0.2));
        this.addDefensive.prefHeightProperty().bind(bottom.heightProperty().multiply(0.4));

        done.setOnAction(e -> getOutput());
        this.done.prefWidthProperty().bind(bottom.widthProperty().multiply(0.9));
        this.done.prefHeightProperty().bind(bottom.heightProperty().multiply(0.2));
        this.done.setDisable(true);
        
    }

    private void addPlayer(PlayerAI playerType) {
        if(this.counter >= MAX_PLAYERS) {
            return;
        }
        this.counter++;
        String nickname = this.field.getText().isBlank() ? playerType.toString() + Integer.toString(this.counter) : this.field.getText();
        Color color = this.playerColors.removeFirst();
        VBox box = new VBox();
        Label name = new Label(nickname);
        name.setPrefWidth(Double.MAX_VALUE);
        name.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        box.getChildren().add(name);
        box.setBackground(
            new Background(
                new BackgroundFill(color, new CornerRadii(5), Insets.EMPTY)
            )
        );
        box.prefWidthProperty().bind(top.widthProperty().multiply(0.25));
        box.prefHeightProperty().bind(top.heightProperty().multiply(0.30));
        name.setAlignment(Pos.CENTER);
        name.setPadding(new Insets(5));
        VBox.setMargin(name, new Insets(5, 10, 0, 10));

        box.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(5))));
        FlowPane.setMargin(box, new Insets(10));
        box.setOnMouseClicked(
            e -> {
                int i = top.getChildren().indexOf(box);
                top.getChildren().remove(i);
                var temp = players.remove(i);
                this.playerColors.add(temp.color());
                this.counter--;
                this.done.setDisable(counter < MIN_PLAYERS);
            }
        );
        top.getChildren().add(box);
        players.add(new PlayerRequest(nickname, playerType, color));
        this.field.setText("");
        this.done.setDisable(counter < MIN_PLAYERS);
    }

    private void getOutput() {
        for (PlayerRequest playerRequest : players) {
            System.out.print(playerRequest.name());
        }
        this.onDone.accept(players);
    }
}
