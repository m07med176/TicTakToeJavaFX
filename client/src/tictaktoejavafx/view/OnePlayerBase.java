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
    protected final TextField player_name;
    protected final Button StartGame;
    protected final Button button;

    public OnePlayerBase() {

        imageView = new ImageView();
        label = new Label();
        player_name = new TextField();
        StartGame = new Button();
        button = new Button();

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
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));
        
        label.setLayoutX(326.0);
        label.setLayoutY(217.0);
        label.getStyleClass().add("title");
        label.setText("Tic Tac Toe");

        player_name.setLayoutX(251.0);
        player_name.setLayoutY(315.0);
        player_name.setPrefHeight(30.0);
        player_name.setPrefWidth(224.0);
        player_name.setPromptText("Player Name");
        player_name.getStyleClass().add("main_input");

        StartGame.setLayoutX(316.0);
        StartGame.setLayoutY(366.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");

        button.setLayoutX(14.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(player_name);
        getChildren().add(StartGame);
        getChildren().add(button);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
