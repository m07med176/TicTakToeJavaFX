package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class OnePlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField player_name;
    protected final Button StartGame;

    public OnePlayerBase() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        player_name = new TextField();
        StartGame = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(513.0);
        setPrefWidth(712.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(263.0);
        imageView.setLayoutY(52.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setLayoutX(326.0);
        label.setLayoutY(217.0);
        label.setText("Tic Tac Toe");

        label0.setLayoutX(159.0);
        label0.setLayoutY(306.0);
        label0.setText("Player Name");

        player_name.setLayoutX(263.0);
        player_name.setLayoutY(301.0);
        player_name.setPrefHeight(30.0);
        player_name.setPrefWidth(224.0);

        StartGame.setLayoutX(316.0);
        StartGame.setLayoutY(366.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setText("Start Game");
        
        imageView.setImage(new Image(Config.LOGO));
        
        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(player_name);
        getChildren().add(StartGame);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

}
