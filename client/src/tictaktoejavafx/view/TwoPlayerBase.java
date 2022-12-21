package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;



public abstract class TwoPlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField player_One;
    protected final TextField Player_two;
    protected final Button btn_single;
    protected final Button button,StartGame;
    protected final ImageView imageView0;

    public TwoPlayerBase() {
StartGame = new Button();
        imageView = new ImageView();
        player_One = new TextField();
        Player_two = new TextField();
        btn_single = new Button();
        button = new Button();
        imageView0 = new ImageView();

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

        player_One.setLayoutX(230.0);
        player_One.setLayoutY(300.0);
        player_One.setPrefHeight(31.0);
        player_One.setPrefWidth(217.0);
        player_One.setPromptText("First Player");
        player_One.getStyleClass().add("main_input");

        Player_two.setLayoutX(230.0);
        Player_two.setLayoutY(345.0);
        Player_two.setPrefHeight(31.0);
        Player_two.setPrefWidth(217.0);
        Player_two.setPromptText("Second Player");
        Player_two.getStyleClass().add("main_input");

        btn_single.setLayoutX(263.0);
        btn_single.setLayoutY(397.0);
        btn_single.setMnemonicParsing(false);
        btn_single.setOnAction(this::isSingle);
        btn_single.setPrefHeight(42.0);
        btn_single.setPrefWidth(150.0);
        btn_single.getStyleClass().add("main_button");
        btn_single.setText("Start Game");
        btn_single.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_single.setFont(new Font(22.0));

        StartGame.setLayoutX(265.0);
        StartGame.setLayoutY(402.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.setPrefHeight(25.0);
        StartGame.setPrefWidth(123.0);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");
        StartGame.setFont(new Font("System Bold Italic", 12.0));

        button.setLayoutX(24.0);
        button.setLayoutY(24.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");

        button.setText("<");

        imageView0.setFitHeight(183.0);
        imageView0.setFitWidth(200.0);
        imageView0.setLayoutX(270.0);
        imageView0.setLayoutY(49.0);
        imageView0.getStyleClass().add("logo");
       // imageView0.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
imageView.setImage(new Image(Config.LOGO));
        getChildren().add(imageView);
        getChildren().add(player_One);
        getChildren().add(Player_two);
        getChildren().add(btn_single);
        getChildren().add(button);
        getChildren().add(imageView0);

    }

    protected abstract void isSingle(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);
    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

}
