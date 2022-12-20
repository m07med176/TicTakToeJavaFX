package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class TwoPlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField player_One;
    protected final TextField Player_two;
    protected final Button StartGame;
    protected final Button button;

    public TwoPlayerBase() {

        imageView = new ImageView();
        player_One = new TextField();
        Player_two = new TextField();
        StartGame = new Button();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(534.0);
        setPrefWidth(658.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(226.0);
        imageView.setLayoutY(80.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));

        player_One.setLayoutX(229.0);
        player_One.setLayoutY(273.0);
        player_One.setPrefHeight(31.0);
        player_One.setPrefWidth(217.0);
        player_One.setPromptText("First Player");
        player_One.getStyleClass().add("main_input");

        Player_two.setLayoutX(229.0);
        Player_two.setLayoutY(346.0);
        Player_two.setPrefHeight(31.0);
        Player_two.setPrefWidth(217.0);
        Player_two.setPromptText("Second Player");
        Player_two.getStyleClass().add("main_input");

        StartGame.setLayoutX(288.0);
        StartGame.setLayoutY(401.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");

        button.setLayoutX(25.0);
        button.setLayoutY(21.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("back_button");
        button.setText("<");
        button.setOnAction(this::isBack);

        getChildren().add(imageView);
        getChildren().add(player_One);
        getChildren().add(Player_two);
        getChildren().add(StartGame);
        getChildren().add(button);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);
    protected abstract void isBack(javafx.event.ActionEvent actionEvent);

}
