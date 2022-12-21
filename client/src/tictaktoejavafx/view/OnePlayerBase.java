package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Config;


public abstract class OnePlayerBase extends AnchorPane {

    protected final TextField player_name;
    protected final Button button;
      protected final Button StartGame;
    protected final Button btn_single;
    protected final ImageView imageView;

    protected final ImageView imageView0;

    public OnePlayerBase() {

        player_name = new TextField();
        button = new Button();

        StartGame = new Button();
        btn_single = new Button();
        imageView = new ImageView();

        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(513.0);
        setPrefWidth(712.0);


        player_name.setLayoutX(225.0);
        player_name.setLayoutY(311.0);

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

        btn_single.setLayoutX(259.0);
        btn_single.setLayoutY(375.0);
        btn_single.setMnemonicParsing(false);
        btn_single.setOnAction(this::isSingle);
        btn_single.setPrefHeight(42.0);
        btn_single.setPrefWidth(150.0);
        btn_single.getStyleClass().add("main_button");
        btn_single.setText("Start Game");
        btn_single.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_single.setFont(new Font(22.0));

        imageView.setFitHeight(185.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(225.0);
        imageView.setLayoutY(35.0);
        imageView.getStyleClass().add("logo");
        //imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));
 imageView.setImage(new Image(Config.LOGO));

        getChildren().add(imageView);
        getChildren().add(player_name);
        getChildren().add(button);
        getChildren().add(btn_single);
//        getChildren().add(imageView);

    }

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

    protected abstract void isSingle(javafx.event.ActionEvent actionEvent);

}
