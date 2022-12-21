package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class OnePlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField player_name;
    protected final Button StartGame;
    protected final Button button;
    protected final ImageView imageView0;

    public OnePlayerBase() {

        imageView = new ImageView();
        player_name = new TextField();
        StartGame = new Button();
        button = new Button();
        imageView0 = new ImageView();

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

        player_name.setLayoutX(251.0);
        player_name.setLayoutY(315.0);
        player_name.setPrefHeight(30.0);
        player_name.setPrefWidth(224.0);
        player_name.setPromptText("Player Name");
        player_name.getStyleClass().add("main_input");

        StartGame.setLayoutX(298.0);
        StartGame.setLayoutY(385.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setPrefHeight(25.0);
        StartGame.setPrefWidth(130.0);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");
        StartGame.setFont(new Font("System Bold Italic", 12.0));

        button.setLayoutX(14.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        imageView0.setFitHeight(136.0);
        imageView0.setFitWidth(168.0);
        imageView0.setLayoutX(298.0);
        imageView0.setLayoutY(59.0);
        imageView0.getStyleClass().add("logo");
        imageView0.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(player_name);
        getChildren().add(StartGame);
        getChildren().add(button);
        getChildren().add(imageView0);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
