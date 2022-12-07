package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class TwoPlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final TextField player_One;
    protected final TextField Player_two;
    protected final Button StartGame;

    public TwoPlayerBase() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        player_One = new TextField();
        Player_two = new TextField();
        StartGame = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(534.0);
        setPrefWidth(658.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(229.0);
        imageView.setLayoutY(42.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setLayoutX(294.0);
        label.setLayoutY(221.0);
        label.setText("Tic Tac Toe");

        label0.setLayoutX(117.0);
        label0.setLayoutY(278.0);
        label0.setText("Player Name1");

        label1.setLayoutX(112.0);
        label1.setLayoutY(346.0);
        label1.setPrefHeight(31.0);
        label1.setPrefWidth(101.0);
        label1.setText("Player Name 2");

        player_One.setLayoutX(229.0);
        player_One.setLayoutY(273.0);
        player_One.setPrefHeight(31.0);
        player_One.setPrefWidth(217.0);

        Player_two.setLayoutX(229.0);
        Player_two.setLayoutY(346.0);
        Player_two.setPrefHeight(31.0);
        Player_two.setPrefWidth(217.0);

        StartGame.setLayoutX(288.0);
        StartGame.setLayoutY(401.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setText("Start Game");

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(player_One);
        getChildren().add(Player_two);
        getChildren().add(StartGame);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

}
