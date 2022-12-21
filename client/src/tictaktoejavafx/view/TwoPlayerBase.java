package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;

public abstract class TwoPlayerBase extends AnchorPane {

    protected final TextField player_One;
    protected final TextField Player_two;
    protected final Button StartGame;
    protected final ImageView imageView;
    protected final Button button;

    public TwoPlayerBase() {

        player_One = new TextField();
        Player_two = new TextField();
        StartGame = new Button();
        imageView = new ImageView();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(534.0);
        setPrefWidth(658.0);

        player_One.setLayoutX(229.0);
        player_One.setLayoutY(267.0);
        player_One.setPrefHeight(31.0);
        player_One.setPrefWidth(217.0);
        player_One.setPromptText("First Player");
        player_One.getStyleClass().add("main_input");

        Player_two.setLayoutX(229.0);
        Player_two.setLayoutY(326.0);
        Player_two.setPrefHeight(31.0);
        Player_two.setPrefWidth(217.0);
        Player_two.setPromptText("Second Player");
        Player_two.getStyleClass().add("main_input");

        StartGame.setLayoutX(276.0);
        StartGame.setLayoutY(378.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setPrefHeight(25.0);
        StartGame.setPrefWidth(123.0);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");
        StartGame.setFont(new Font("System Bold Italic", 12.0));

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(254.0);
        imageView.setLayoutY(68.0);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));
        
        button.setLayoutX(39.0);
        button.setLayoutY(35.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        Image img = new Image("tictaktoejavafx/assets/images/back.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        button.setGraphic(view);

        getChildren().add(player_One);
        getChildren().add(Player_two);
        getChildren().add(StartGame);
        getChildren().add(imageView);
        getChildren().add(button);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
