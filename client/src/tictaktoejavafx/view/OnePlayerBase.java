package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;

public abstract class OnePlayerBase extends Pane {

    protected final TextField player_name;
    protected final ImageView imageView;
    protected final Button StartGame;
    protected final Button button;

    public OnePlayerBase() {

        player_name = new TextField();
        imageView = new ImageView();
        StartGame = new Button();
        button = new Button();

        setPrefHeight(534.0);
        setPrefWidth(658.0);

        player_name.setLayoutX(211.0);
        player_name.setLayoutY(318.0);
        player_name.setPrefHeight(30.0);
        player_name.setPrefWidth(224.0);
        player_name.setPromptText("Player Name");
        player_name.getStyleClass().add("main_input");

        imageView.setFitHeight(136.0);
        imageView.setFitWidth(168.0);
        imageView.setLayoutX(239.0);
        imageView.setLayoutY(82.0);
        imageView.getStyleClass().add("logo");
        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
 imageView.setImage(new Image(Config.LOGO));
        StartGame.setLayoutX(258.0);
        StartGame.setLayoutY(372.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setPrefHeight(25.0);
        StartGame.setPrefWidth(130.0);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");
        StartGame.setFont(new Font("System Bold Italic", 12.0));

        button.setLayoutX(29.0);
        button.setLayoutY(25.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        //------------------------------------
        Image img = new Image("tictaktoejavafx/assets/images/back.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(30);
        view.setFitWidth(30);
        view.setPreserveRatio(true);
        button.setGraphic(view);
//-------------------------------------

        getChildren().add(player_name);
        getChildren().add(imageView);
        getChildren().add(StartGame);
        getChildren().add(button);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
